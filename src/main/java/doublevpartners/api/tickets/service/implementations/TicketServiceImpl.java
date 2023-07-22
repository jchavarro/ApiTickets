package doublevpartners.api.tickets.service.implementations;

import doublevpartners.api.tickets.exceptions.types.BadRequestException;
import doublevpartners.api.tickets.exceptions.types.NotFoundException;
import doublevpartners.api.tickets.model.entities.TicketEntity;
import doublevpartners.api.tickets.model.repositories.TicketRepository;
import doublevpartners.api.tickets.service.interfaces.TicketService;
import doublevpartners.api.tickets.web.dto.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de los servicios de Ticket.
 */
@AllArgsConstructor
@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    /**
     * Repositorio de tickets.
     */
    @Autowired
    private TicketRepository ticketRepository;

    /**
     * Permite la conversión de un objeto a otro que tenga atributos en común.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Consulta de tickets.
     *
     * @param numeroPagina Numero de pagina
     * @param tamanoPagina Tamaño de pagina
     * @return Lista de tickets
     */
    @Override
    public List<TicketDTO> getAllTickets(final Integer numeroPagina, final Integer tamanoPagina) {
        log.info("Consulta de tickets de la pagina" + numeroPagina + " con un tamaño de pagina de " + tamanoPagina);
        return ticketRepository.findAll(PageRequest.of(numeroPagina, tamanoPagina)).getContent()
                .stream()
                .map(ticketEntity -> modelMapper.map(ticketEntity, TicketDTO.class))
                .toList();
    }

    /**
     * Creacion de tickets.
     *
     * @param ticketDTO Ticket a crear
     * @return Ticket creado
     */
    @Override
    public TicketDTO createTicket(final TicketDTO ticketDTO) {
        log.info("Creacion del ticket " + ticketDTO.getUsuario());
        if (Boolean.TRUE.equals(validateTicket(ticketDTO))) {
            return modelMapper.map(ticketRepository
                    .save(modelMapper.map(ticketDTO, TicketEntity.class)), TicketDTO.class);
        } else throw new BadRequestException("Los campos de id y usuario y fechas son obligatorios "
                + ticketDTO.getTicketId());
    }

    /**
     * Actualizacion de tickets.
     *
     * @param ticketDTO Ticket a actualizar
     * @return Ticket actualizado
     */
    @Override
    public TicketDTO updateTicket(final TicketDTO ticketDTO) {
        log.info("Actualizacion del ticket " + ticketDTO.getTicketId());
        if (ticketDTO.getTicketId() != null) {
            ticketRepository.findById(ticketDTO.getTicketId())
                    .orElseThrow(() -> new NotFoundException("No se ha encontrado el ticket: "
                            + ticketDTO.getTicketId()));
            return modelMapper.map(ticketRepository.save(modelMapper.map(ticketDTO, TicketEntity.class)),
                    TicketDTO.class);
        } else throw new BadRequestException("El id del ticket es obligatorio");
    }

    /**
     * Eliminacion de tickets.
     *
     * @param id Id del ticket a eliminar
     * @return Booleano de confirmacion
     */
    @Override
    public Boolean deleteTicket(final Integer id) {
        log.info("Eliminacion del ticket " + id);
        ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado el ticket: " + id));
        ticketRepository.deleteById(id);
        return Boolean.TRUE;
    }

    /**
     * Validacion de ticket.
     *
     * @param ticketDTO Ticket a validar
     * @return Booleano de confirmacion
     */
    private Boolean validateTicket(TicketDTO ticketDTO) {
        return !ticketDTO.getUsuario().equals("")
                && ticketDTO.getFechaCreacion() != null
                && ticketDTO.getFechaActualizacion() != null;
    }
}

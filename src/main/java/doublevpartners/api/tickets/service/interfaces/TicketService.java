package doublevpartners.api.tickets.service.interfaces;

import doublevpartners.api.tickets.web.dto.TicketDTO;

import java.util.List;

/**
 * Interface para el Ticket Service
 */
public interface TicketService {

    /**
     * Consulta de tickets.
     * @param numeroPagina Numero de pagina
     * @param tamanoPagina  Tamaño de pagina
     * @return Lista de tickets
     */
    List<TicketDTO> getAllTickets(Integer numeroPagina, Integer tamanoPagina);

    /**
     * Creacion de tickets.
     * @param ticketDTO Ticket a crear
     * @return Ticket creado
     */
    TicketDTO createTicket(TicketDTO ticketDTO);

    /**
     * Actualizacion de tickets.
     * @param ticketDTO Ticket a actualizar
     * @return Ticket actualizado
     */
    TicketDTO updateTicket(TicketDTO ticketDTO);

    /**
     * Eliminacion de tickets.
     * @param id Id del ticket a eliminar
     * @return Booleano que indica si se elimino o no el ticket
     */
    Boolean deleteTicket(Integer id);
}

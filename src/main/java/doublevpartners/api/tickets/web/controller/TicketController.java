package doublevpartners.api.tickets.web.controller;

import doublevpartners.api.tickets.service.interfaces.TicketService;
import doublevpartners.api.tickets.web.dto.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase controlador de tickets.
 */
@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {
    /**
     * Servicio de tickets.
     */
    @Autowired
    private TicketService ticketService;

    /**
     * Metodo para obtener un ticket por id.
     * @param numeroPagina Numero de pagina
     * @param tamanoPagina Tamaño de pagina
     * @return Lista de tickets paginados
     */
    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets(@RequestParam("numeroPagina") final Integer numeroPagina,
                                                         @RequestParam("tamanoPagina") final Integer tamanoPagina){
        return new ResponseEntity<>(ticketService.getAllTickets(numeroPagina, tamanoPagina), HttpStatus.OK);
    }

    /**
     * Metodo para crear un ticket.
     * @param ticketDTO Ticket a crear
     * @return Ticket creado
     */
    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody final TicketDTO ticketDTO){
        return new ResponseEntity<>(ticketService.createTicket(ticketDTO), HttpStatus.CREATED);
    }

    /**
     * Metodo para actualizar un ticket.
     * @param ticketDTO Ticket a actualizar
     * @return Ticket actualizado
     */
    @PutMapping
    public ResponseEntity<TicketDTO> updateTicket(@RequestBody final TicketDTO ticketDTO){
        return new ResponseEntity<>(ticketService.updateTicket(ticketDTO), HttpStatus.OK);
    }

    /**
     * Metodo para eliminar un ticket.
     * @param id Id del ticket a eliminar
     * @return Booleano que indica si se elimino o no el ticket
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteTicket(@RequestParam("id") final Integer id){
        return new ResponseEntity<>(ticketService.deleteTicket(id), HttpStatus.OK);
    }
}

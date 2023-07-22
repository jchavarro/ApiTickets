package doublevpartners.api.tickets.service.interfaces;

import doublevpartners.api.tickets.web.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    List<TicketDTO> getAllTickets(Integer numeroPagina, Integer tamanoPagina);

    TicketDTO createTicket(TicketDTO ticketDTO);

    TicketDTO updateTicket(TicketDTO ticketDTO);

    Boolean deleteTicket(Integer id);
}

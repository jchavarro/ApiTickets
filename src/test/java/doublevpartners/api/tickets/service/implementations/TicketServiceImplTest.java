package doublevpartners.api.tickets.service.implementations;

import doublevpartners.api.tickets.model.entities.TicketEntity;
import doublevpartners.api.tickets.model.repositories.TicketRepository;
import doublevpartners.api.tickets.web.dto.TicketDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceImplTest {


    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private TicketServiceImpl ticketService;

    @Test
    void testGetAllTickets() {
        List<TicketEntity> ticketEntities = new ArrayList<>();
        ticketEntities.add(new TicketEntity());
        ticketEntities.add(new TicketEntity());

        when(ticketRepository.findAll(any(PageRequest.class))).thenReturn(new PageImpl<>(ticketEntities));

        List<TicketDTO> expectedTicketDTOs = new ArrayList<>();
        expectedTicketDTOs.add(new TicketDTO());
        expectedTicketDTOs.add(new TicketDTO());

        when(modelMapper.map(any(TicketEntity.class), eq(TicketDTO.class))).thenReturn(new TicketDTO());

        List<TicketDTO> result = ticketService.getAllTickets(0, 10);

        assertEquals(expectedTicketDTOs, result);
        verify(ticketRepository).findAll(any(PageRequest.class));
        verify(modelMapper, times(ticketEntities.size())).map(any(TicketEntity.class), eq(TicketDTO.class));
    }

}
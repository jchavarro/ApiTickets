package doublevpartners.api.tickets.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {

    private Integer ticketId;

    private String usuario;

    private Date fechaCreacion;

    private Date fechaActualizacion;

    private String status;

}

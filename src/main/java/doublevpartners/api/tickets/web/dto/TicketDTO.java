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

    /**
     * Id del ticket
     */
    private Integer ticketId;

    /**
     * Nombre del usuario
     */
    private String usuario;

    /**
     * Fecha de creacion del ticket
     */
    private Date fechaCreacion;

    /**
     * Fecha de actualizacion del ticket
     */
    private Date fechaActualizacion;

    /**
     * Estado del ticket
     */
    private String status;

}

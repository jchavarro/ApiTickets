package doublevpartners.api.tickets.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Entidad que representa la tabla ticket
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ticket")
public class TicketEntity {

    /**
     * Id del ticket
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketId;

    /**
     * Nombre del usuario
     */
    private String usuario;

    /**
     * Fecha de creacion del ticket
     */
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    /**
     * Fecha de actualizacion del ticket
     */
    @Column(name = "fecha_Actualizacion")
    private Date fechaActualizacion;

    /**
     * Estado del ticket
     */
    private String status;
}

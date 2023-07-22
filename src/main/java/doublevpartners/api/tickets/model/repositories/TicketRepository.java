package doublevpartners.api.tickets.model.repositories;

import doublevpartners.api.tickets.model.entities.TicketEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de tickets.
 */
@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    /**
     * Busqueda de tickets por id.
     * @param pageable paginador del ticket.
     * @return tickets encontrados.
     */
    Page<TicketEntity> findAll(Pageable pageable);
}

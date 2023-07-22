package doublevpartners.api.tickets.model.repositories;

import doublevpartners.api.tickets.model.entities.TicketEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    Page<TicketEntity> findAll(Pageable pageable);
}

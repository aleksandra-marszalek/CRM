package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.crm.entity.Status;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findStatusById (Long id);

    List<Status> findAllByActiveTrue();
}

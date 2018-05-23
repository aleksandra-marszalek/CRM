package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.crm.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findProjectById (Long id);
}

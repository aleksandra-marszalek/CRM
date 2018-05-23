package pl.coderslab.crm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.entity.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findTaskById (Long id);
}

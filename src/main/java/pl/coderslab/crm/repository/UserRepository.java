package pl.coderslab.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.crm.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById (Long id);
}

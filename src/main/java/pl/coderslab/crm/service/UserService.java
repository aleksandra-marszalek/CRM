package pl.coderslab.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save (User user) {
        userRepository.save(user);
    }

    public void delete (User user) {
        userRepository.delete(user);
    }

    public User findById (Long id) {
        return userRepository.findUserById(id);
    }

    public List<User> allUsers () {
        return userRepository.findAll();
    }
}

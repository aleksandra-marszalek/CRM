package pl.coderslab.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.BCrypt;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String encrypt (String password) {
        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return encryptedPassword;
    }

    public void addUser(User user) {
        String password = user.getPassword();
        user.setPassword(encrypt(password));
        userRepository.save(user);
    }

    public boolean checkUser(User user, String password) {
        if (BCrypt.checkpw(password, user.getPassword())) {
            return true;
        }
        return false;
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

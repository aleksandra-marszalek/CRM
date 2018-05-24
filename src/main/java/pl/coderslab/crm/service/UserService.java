package pl.coderslab.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.BCrypt;
import pl.coderslab.crm.entity.Role;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.repository.RoleRepository;
import pl.coderslab.crm.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

//    public String encrypt (String password) {
//        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//        return encryptedPassword;
//    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
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

    public User findByLogin(String login) { return userRepository.findUserByLogin(login);
    }
}

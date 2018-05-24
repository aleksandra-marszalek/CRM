package pl.coderslab.crm.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.service.ProjectService;
import pl.coderslab.crm.service.UserService;

public class UserConverter implements Converter<String, User> {

    @Autowired
    UserService userService;

    @Override
    public User convert(String s) {
        return userService.findById(Long.parseLong(s));
    }
}

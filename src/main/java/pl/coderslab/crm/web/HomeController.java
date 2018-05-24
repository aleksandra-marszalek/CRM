package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.service.*;

import java.util.List;

@Controller
public class HomeController {

//    @Autowired
//    ProjectService projectService;
//
//    @Autowired
//    PriorityService priorityService;
//

//
//    @Autowired
//    StatusService statusService;
//
//    @Autowired
//    TaskService taskService;


    @GetMapping("/")
    public String home () {
        return "home";
    }












    ////////////// MODEL ///////////////
//
//    @ModelAttribute("users")
//    public List<User> users() {
//        return userService.allUsers();
//    }
}

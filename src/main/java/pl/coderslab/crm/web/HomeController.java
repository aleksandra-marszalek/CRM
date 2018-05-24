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

    @Autowired
    ProjectService projectService;

    @Autowired
    PriorityService priorityService;

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @Autowired
    TaskService taskService;


    @GetMapping("/")
    public String home () {
        return "home";
    }


    ///////////// PROJECTS ///////////

    @GetMapping("/project/allProjects")
    public String allProjects (Model model) {
        List<Project> allProjects = projectService.allProjects();
        model.addAttribute("allProjects", allProjects);
        return "allProjects";
    }








    ////////////// MODEL ///////////////

    @ModelAttribute("users")
    public List<User> users() {
        return userService.allUsers();
    }
}

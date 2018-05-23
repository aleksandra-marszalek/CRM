package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.entity.Priority;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Status;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.service.PriorityService;
import pl.coderslab.crm.service.ProjectService;
import pl.coderslab.crm.service.StatusService;
import pl.coderslab.crm.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    ProjectService projectService;

    @Autowired
    PriorityService priorityService;

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;



    @GetMapping("/")
    public String adminPanel () {
        return "adminPanel";
    }

    @GetMapping("/projectList")
    public String projectList (Model model) {
        List<Project> allProjects = projectService.allProjects();
        model.addAttribute("allProjects", allProjects);
        return "projectList";
    }

    @GetMapping("/priorityList")
    public String priorityList (Model model) {
        List<Priority> allPriorities = priorityService.allPriorities();
        model.addAttribute("allPriorities", allPriorities);
        return "priorityList";
    }

    @GetMapping("/userList")
    public String userList (Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("allUsers", users);
        return "userList";
    }

    @GetMapping("/statusList")
    public String statusList (Model model) {
        List<Status> allStatuses = statusService.allStatuses();
        model.addAttribute("allStatuses", allStatuses);
        return "statusList";
    }
}

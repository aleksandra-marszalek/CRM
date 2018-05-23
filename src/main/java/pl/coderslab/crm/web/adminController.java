package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.entity.Priority;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Status;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.service.PriorityService;
import pl.coderslab.crm.service.ProjectService;
import pl.coderslab.crm.service.StatusService;
import pl.coderslab.crm.service.UserService;

import javax.validation.Valid;
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

    /////////////// PROJECT ///////////////////

    @GetMapping("/projectList")
    public String projectList (Model model) {
        List<Project> allProjects = projectService.allProjects();
        model.addAttribute("allProjects", allProjects);
        return "projectList";
    }

    @GetMapping("/addProject")
    public String addProject(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "addProject";
    }

    @PostMapping("/addProject")
    public String addProject(@Valid @ModelAttribute Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "addProject";
        }
        projectService.save(project);
        return "redirect:/admin/projectList";
    }

    ////////////// PRIORITY //////////////////

    @GetMapping("/priorityList")
    public String priorityList (Model model) {
        List<Priority> allPriorities = priorityService.allPriorities();
        model.addAttribute("allPriorities", allPriorities);
        return "priorityList";
    }

    @GetMapping("/addPriority")
    public String addPriority(Model model) {
        Priority priority = new Priority();
        model.addAttribute("priority", priority);
        return "addPriority";
    }

    @PostMapping("/addPriority")
    public String addPriority(@Valid @ModelAttribute Priority priority, BindingResult result) {
        if (result.hasErrors()) {
            return "addPriority";
        }
        priorityService.save(priority);
        return "redirect:/admin/priorityList";
    }

    /////////////////// USER //////////////////

    @GetMapping("/userList")
    public String userList (Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("allUsers", users);
        return "userList";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        }

        userService.addUser(user);
        return "redirect:/admin/userList";
    }


    /////////////// STATUS ///////////////////


    @GetMapping("/statusList")
    public String statusList (Model model) {
        List<Status> allStatuses = statusService.allStatuses();
        model.addAttribute("allStatuses", allStatuses);
        return "statusList";
    }

    @GetMapping("/addStatus")
    public String addStatus(Model model) {
        Status status = new Status();
        model.addAttribute("status", status);
        return "addStatus";
    }

    @PostMapping("/addStatus")
    public String addStatus(@Valid @ModelAttribute Status status, BindingResult result) {
        if (result.hasErrors()) {
            return "addStatus";
        }
        statusService.save(status);
        return "redirect:/admin/statusList";
    }
}

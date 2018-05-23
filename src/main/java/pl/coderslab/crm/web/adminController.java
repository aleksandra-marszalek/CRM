package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
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

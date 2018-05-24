package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.*;
import pl.coderslab.crm.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/project")
public class projectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @Autowired
    PriorityService priorityService;

    @GetMapping("/allProjects")
    public String allProjects (Model model) {
        List<Project> allProjects = projectService.allProjects();
        model.addAttribute("allProjects", allProjects);
        return "allProjects";
    }

    @GetMapping("/{id}/showProject")
    public String showProject (Model model, @PathVariable Long id) {
        Project project = projectService.findById(id);
        model.addAttribute("project", project);
        return "ProjectPage";
    }

    @GetMapping("/{id}/taskList")
    public String showTasks (Model model, @PathVariable Long id) {
        Project project = projectService.findById(id);
        model.addAttribute("project", project);
        List<Task> projectTasks = taskService.findAllByProjectId(id);
        model.addAttribute("allTasks", projectTasks);
        return "allTasks";
    }

    @GetMapping("/{id}/addTask")
    public String addTask (Model model, @PathVariable Long id) {
        Task task = new Task();
        Project project = projectService.findById(id);
        List<User> currentUsers = project.getUsers();
        model.addAttribute("id", id);
        model.addAttribute("task", task);
        model.addAttribute("currentUsers", currentUsers);
        return "addTask";
    }

    @PostMapping("/{id}/addTask")
    public String addTask (@Valid @ModelAttribute Task task, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "addTask";
        }
        Project project = projectService.findById(id);
        task.setProject(project);
        taskService.save(task);
        return "redirect:/project/"+id+"/taskList";
    }





    ///////////////////MODEL////////////////////

    @ModelAttribute("users")
    public List<User> users() {
        return userService.allUsers();
    }

    @ModelAttribute("statuses")
    public List<Status> statuses() {
        return statusService.findAllActive();
    }

    @ModelAttribute("priorities")
    public List<Priority> priorities() {
        return priorityService.findAllActive();
    }
}

package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.service.ProjectService;
import pl.coderslab.crm.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/project")
public class projectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

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





    ///////////////////MODEL////////////////////

    @ModelAttribute("users")
    public List<User> users() {
        return userService.allUsers();
    }
}

package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.service.ProjectService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    ProjectService projectService;


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
}

package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.service.TaskService;

@Controller
@RequestMapping("/task")
public class taskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/{id}/showTask")
    public String showTask(Model model, @PathVariable Long id) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "TaskPage";
    }
}

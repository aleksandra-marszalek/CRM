package pl.coderslab.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.repository.TaskRepository;
import pl.coderslab.crm.repository.TaskRepository;

import java.util.List;

public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void save (Task task) {
        taskRepository.save(task);
    }

    public void delete (Task task) {
        taskRepository.delete(task);
    }

    public Task findById (Long id) {
        return taskRepository.findTaskById(id);
    }

    public List<Task> allTasks () {
        return taskRepository.findAll();
    }
}

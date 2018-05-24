package pl.coderslab.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.repository.TaskRepository;
import pl.coderslab.crm.repository.TaskRepository;

import java.util.List;

@Service
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

    public List<Task> findAllByProjectId (Long projectId) {
        return taskRepository.findAllByProjectId(projectId);
    }
}

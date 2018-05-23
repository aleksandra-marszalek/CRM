package pl.coderslab.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.repository.ProjectRepository;
import pl.coderslab.crm.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public String getId (String name) {
        String identificator = name.replaceAll(" ", "-");
        return identificator;
    }

    public void save (Project project) {
        project.setIdentificator(getId(project.getName()));
        projectRepository.save(project);
    }

    public void delete (Project project) {
        projectRepository.delete(project);
    }

    public Project findById (Long id) {
        return projectRepository.findProjectById(id);
    }

    public List<Project> allProjects () {
        return projectRepository.findAll();
    }
}

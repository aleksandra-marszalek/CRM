package pl.coderslab.crm.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.service.ProjectService;

public class ProjectConverter implements Converter<String, Project>{

    @Autowired
    ProjectService projectService;

    @Override
    public Project convert(String s) {
        return projectService.findById(Long.parseLong(s));
    }
}

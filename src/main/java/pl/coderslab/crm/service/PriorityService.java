package pl.coderslab.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Priority;
import pl.coderslab.crm.repository.PriorityRepository;

import java.util.List;

@Service
public class PriorityService {

    @Autowired
    PriorityRepository priorityRepository;

    public void save (Priority priority) {
        priorityRepository.save(priority);
    }

    public void delete (Priority priority) {
        priorityRepository.delete(priority);
    }

    public Priority findById (Long id) {
        return priorityRepository.findPriorityById(id);
    }

    public List<Priority> allPrioritys () {
        return priorityRepository.findAll();
    }
}

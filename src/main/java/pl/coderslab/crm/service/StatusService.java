package pl.coderslab.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.crm.entity.Status;
import pl.coderslab.crm.repository.StatusRepository;
import pl.coderslab.crm.repository.StatusRepository;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public void save (Status status) {
        statusRepository.save(status);
    }

    public void delete (Status status) {
        statusRepository.delete(status);
    }

    public Status findById (Long id) {
        return statusRepository.findStatusById(id);
    }

    public List<Status> allStatuses () {
        return statusRepository.findAll();
    }

    public List<Status> findAllActive () {
        return statusRepository.findAllByActiveTrue();
    }
}

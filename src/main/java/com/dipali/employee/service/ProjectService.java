package com.dipali.employee.service;

import com.dipali.employee.entity.Project;
import com.dipali.employee.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createPro(Project pro) {

        return this.projectRepository.save(pro);
    }

    public List<Project> getPro() {

        return this.projectRepository.findAll();
    }

    public void deletePro(Long proId) {
        Project project = this.projectRepository.findById(proId).get();
        this.projectRepository.delete(project);
    }
}

package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.ProjectsEntity;
import com.example.repository.ProjectsRepository;

@Service
public class ProjectService {
	@Autowired
    private ProjectsRepository projectsRepository;

    public List<ProjectsEntity> getOngoingProjects() {
        return projectsRepository.findByStatus("ONGOING");
    }
    
    public long getOngoingProjectsCount() {
        return projectsRepository.countByStatus("ONGOING");
    }

    public long getCompletedProjectsCount() {
        return projectsRepository.countByStatus("COMPLETED");
    }

}

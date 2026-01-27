package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ProjectsEntity;
import com.example.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/ongoing")
    public ResponseEntity<List<ProjectsEntity>> getOngoingProjects() {
        return ResponseEntity.ok(projectService.getOngoingProjects());
    }
    
    @GetMapping("/count/ongoing")
    public ResponseEntity<Long> getOngoingProjectsCount() {
        return ResponseEntity.ok(projectService.getOngoingProjectsCount());
    }

    @GetMapping("/count/completed")
    public ResponseEntity<Long> getCompletedProjectsCount() {
        return ResponseEntity.ok(projectService.getCompletedProjectsCount());
    }

}

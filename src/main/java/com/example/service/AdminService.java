package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.PayrollsEntity;
import com.example.entity.ProjectsEntity;
import com.example.repository.PayrollsRepository;
import com.example.repository.ProjectsRepository;

@Service
public class AdminService {
	
	@Autowired
    private ProjectsRepository projectsRepository;
	
	@Autowired
	private PayrollsRepository payrollsRepository;

    public List<ProjectsEntity> getOngoingProjects() {
        return projectsRepository.findByStatus("ONGOING");
    }
    
    public List<ProjectsEntity> getCompletedProjects() {
        return projectsRepository.findByStatus("COMPLETED");
    }

    public long getCompletedProjectsCount() {
        return projectsRepository.countByStatus("COMPLETED");
    }

	public List<PayrollsEntity> findPayrollsByNetSalaryRange(double min, double max) {
		return payrollsRepository.findPayrollsByNetSalaryRange(min, max);
	}
}

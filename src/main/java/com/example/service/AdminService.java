package com.example.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Sort;
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

	public long getOngoingProjectsCount() {
		return projectsRepository.countByStatus("ONGOING");
	}

	public List<PayrollsEntity> salarySorted(String typ) {

	    if ("ASC".equalsIgnoreCase(typ)) {
	        return payrollsRepository.findAllByOrderByNet_salaryAsc();
	    } 
	    else if ("DESC".equalsIgnoreCase(typ)) {
	        return payrollsRepository.findAllByOrderByNet_salaryDesc();
	    }

	    throw new IllegalArgumentException("Invalid sort type");
	}

}

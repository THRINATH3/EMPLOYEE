package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PayrollsEntity;
import com.example.entity.ProjectsEntity;
import com.example.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	    @Autowired
	    private AdminService adminService;
	    
	
	 	@GetMapping("/ongoing")
	    public ResponseEntity<List<ProjectsEntity>> getOngoingProjects() {
	        return ResponseEntity.ok(adminService.getOngoingProjects());
	    }
	    
	    @GetMapping("/completed")
	    public ResponseEntity<?> getOngoingProjectsCount() {
	        return ResponseEntity.ok(adminService.getCompletedProjects());
	    }

	    @GetMapping("/count/completed")
	    public ResponseEntity<Long> getCompletedProjectsCount() {
	        return ResponseEntity.ok(adminService.getCompletedProjectsCount());
	    }
	    
	    @GetMapping("/net-salary")
		public List<PayrollsEntity> filterByNetSalary(
		        @RequestParam double min,
		        @RequestParam double max) {
		    return adminService.findPayrollsByNetSalaryRange(min, max);
		}
}

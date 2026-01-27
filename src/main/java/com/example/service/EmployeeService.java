package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtos.RegisterResponseDTO;
import com.example.entity.EmployeesEntity;
import com.example.entity.ProjectsEntity;
import com.example.repository.EmployeeRepository;
import com.example.repository.ProjectsRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private ProjectsRepository projectRepository;
    
    public RegisterResponseDTO addEmployee(EmployeesEntity emp) {

        if (employeeRepository.findByEmail(emp.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        emp.setCreated_at(LocalDateTime.now());
        emp.setUpdated_at(LocalDateTime.now());
        EmployeesEntity saved = employeeRepository.save(emp);

        return new RegisterResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getDesignation(),
                saved.getRole(),
                saved.getDate_of_joining()
        );
    }
    
    public List<RegisterResponseDTO> getEmployee(Long pid) {

        ProjectsEntity project = projectRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        List<EmployeesEntity> employees = project.getEmployees();

        return employees.stream()
                .map(emp -> new RegisterResponseDTO(
                        emp.getId(),
                        emp.getName(),
                        emp.getEmail(),
                        emp.getPhone(),
                        emp.getDesignation(),
                        emp.getRole(),
                        emp.getDate_of_joining()
                ))
                .toList();
    }
    
    public long countEmployeesOnNotice() {
        return employeeRepository.countByIsNoticeTrue();
    }

}

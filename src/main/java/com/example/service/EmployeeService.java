package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dtos.LoginReguestDTO;
import com.example.dtos.RegisterResponseDTO;
import com.example.entity.EmployeesEntity;
import com.example.entity.ProjectsEntity;
import com.example.repository.EmployeeRepository;
import com.example.repository.ProjectsRepository;
import com.example.security.JwtUtil;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private ProjectsRepository projectRepository;
   
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;
    
    public RegisterResponseDTO addEmployee(EmployeesEntity emp) {

        if (employeeRepository.findByEmail(emp.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));
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
                saved.getDate_of_joining(),
                saved.getCreated_at(),
                saved.getUpdated_at(),
                saved.isNotice(),
                saved.getNotice_period()
        );
    }
    
    public String loginEmployee(LoginReguestDTO req) {
    	EmployeesEntity res = employeeRepository.findByEmail(req.getUsername());
    	if (res == null) {
            return null;
        }

        if (!passwordEncoder.matches(req.getPassword(),res.getPassword())) {
            return null;
        }
        RegisterResponseDTO toRes = new RegisterResponseDTO(
                res.getId(),
                res.getName(),
                res.getEmail(),
                res.getPhone(),
                res.getDesignation(),
                res.getRole(),
                res.getDate_of_joining(),
                res.getCreated_at(),
                res.getUpdated_at(),
                res.isNotice(),
                res.getNotice_period()
        );

        String token = jwtUtil.generateToken(toRes);
        return token;
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
                        emp.getDate_of_joining(),
                        emp.getCreated_at(),
                        emp.getUpdated_at(),
                        emp.isNotice(),
                        emp.getNotice_period()
                ))
                .toList();
    }
}

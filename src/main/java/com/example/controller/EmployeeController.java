package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.example.dtos.RegisterResponseDTO;
import com.example.entity.EmployeesEntity;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getHome")
	public String getHome() {
		return "hello";
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeesEntity emp) {
		Object res = employeeService.addEmployee(emp);
		if(res != null) return ResponseEntity.ok().body(res);
		return ResponseEntity.badRequest().body("Employee already exist");
	}
	
	@GetMapping("/getEmployees/{pid}")
	public ResponseEntity<?> getEmployee(@PathVariable Long pid){
		 List<RegisterResponseDTO> res = employeeService.getEmployee(pid);
	     return ResponseEntity.ok(res);
	}
}

package com.example.entity;

import java.time.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "projects")
public class ProjectsEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@NotBlank(message = "Project name cannot be empty")
    @Size(max = 100, message = "Project name cannot exceed 100 characters")
    @Column(name="name", nullable = false, length = 100)
    private String name;
	
	@NotBlank(message = "Project description cannot be empty")
    @Size(max = 300, message = "Project description cannot exceed 300 characters")
    @Column(name="description", nullable = false, length = 300)
    private String description;
	
	@NotNull(message = "Start date is required")
    @Column(name = "start_date", nullable = false)
    private LocalDate start_date;
	
	@Column(name = "end_date")
	private LocalDate end_date;
	
	@NotBlank(message = "Project status is required")
    @Column(name="status", nullable = false)
    private String status;
	
	@OneToMany(mappedBy = "project")
	@JsonIgnore
	private List<EmployeesEntity> employees;
	

	public List<EmployeesEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeesEntity> employees) {
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	

}

package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "departments")
public class DepartmentsEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name cannot be empty")
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Location cannot be empty")
    @Column(name="location", nullable = false)
    private String location;
    
    public DepartmentsEntity() {}

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

    
}

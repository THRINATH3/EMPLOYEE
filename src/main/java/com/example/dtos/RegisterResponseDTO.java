package com.example.dtos;

import java.time.LocalDate;

public class RegisterResponseDTO {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String designation;
    private String role;
    private LocalDate date_of_joining;

    public RegisterResponseDTO(
            int id,
            String name,
            String email,
            String phone,
            String designation,
            String role,
            LocalDate date_of_joining
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
        this.role = role;
        this.date_of_joining = date_of_joining;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(LocalDate date_of_joining) {
        this.date_of_joining = date_of_joining;
    }
}

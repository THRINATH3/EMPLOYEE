package com.example.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisterResponseDTO {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String designation;
    private String role;
    private LocalDate dateOfJoining;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isNotice;
    private int noticePeriod;

    public RegisterResponseDTO(
            int id,
            String name,
            String email,
            String phone,
            String designation,
            String role,
            LocalDate dateOfJoining,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            boolean isNotice,
            int noticePeriod
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
        this.role = role;
        this.dateOfJoining = dateOfJoining;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isNotice = isNotice;
        this.noticePeriod = noticePeriod;
    }

    // ---------- Getters & Setters ----------

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

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isNotice() {
        return isNotice;
    }

    public void setNotice(boolean isNotice) {
        this.isNotice = isNotice;
    }

    public int getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(int noticePeriod) {
        this.noticePeriod = noticePeriod;
    }
}

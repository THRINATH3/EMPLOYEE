package com.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Employees")
public class EmployeesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50)
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Designation is required")
    @Column(name = "designation")
    private String designation;
   

	@NotBlank(message = "Role is required")
    @Column(name = "role")
    private String role;

	@ManyToOne
	@JoinColumn(name = "dept_id",nullable = false)
    private DepartmentsEntity department;
    
    @PastOrPresent
    @Column(name = "date_of_joining")
    private LocalDate date_of_joining;

	@Column(name = "isNotice")
    private boolean isNotice;

    @PositiveOrZero(message = "Notice period cannot be negative")
    @Column(name = "notice_period")
    private int notice_period;

    @PastOrPresent
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @PastOrPresent
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "employee")
    private List<PayrollsEntity> payrolls;
   
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectsEntity project;
    
	public List<PayrollsEntity> getPayrolls() {
		return payrolls;
	}


	public void setPayrolls(List<PayrollsEntity> payrolls) {
		this.payrolls = payrolls;
	}


	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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

	

	public DepartmentsEntity getDepartment() {
		return department;
	}


	public void setDepartment(DepartmentsEntity department) {
		this.department = department;
	}


	public ProjectsEntity getProject() {
		return project;
	}


	public void setProject(ProjectsEntity project) {
		this.project = project;
	}


	public boolean isNotice() {
		return isNotice;
	}

	public void setNotice(boolean isNotice) {
		this.isNotice = isNotice;
	}

	public int getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(int notice_period) {
		this.notice_period = notice_period;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	

    public LocalDate getDate_of_joining() {
		return date_of_joining;
	}


	public void setDate_of_joining(LocalDate date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	
}

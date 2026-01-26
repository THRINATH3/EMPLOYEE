package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "Payrolls")
public class PayrollsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeesEntity employee;

    @Positive(message = "Basic salary must be greater than 0")
    @Column(name = "basic_salary")
    private int basic_salary;

    @PositiveOrZero(message = "HRA cannot be negative")
    @Column(name = "hra")
    private double hra;

    @PositiveOrZero(message = "Bonus cannot be negative")
    @Column(name = "bonus")
    private double bonus;

    @PositiveOrZero(message = "Deductions cannot be negative")
    @Column(name = "deductions")
    private double deductions;

    @PositiveOrZero(message = "Net salary cannot be negative")
    @Column(name = "net_salary")
    private double net_salary;

    @PastOrPresent(message = "Pay date cannot be in the future")
    @Column(name = "pay_date")
    private LocalDate pay_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeesEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeesEntity employee) {
		this.employee = employee;
	}

	public int getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(int basic_salary) {
		this.basic_salary = basic_salary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getNet_salary() {
		return net_salary;
	}

	public void setNet_salary(double net_salary) {
		this.net_salary = net_salary;
	}

	public LocalDate getPay_date() {
		return pay_date;
	}

	public void setPay_date(LocalDate pay_date) {
		this.pay_date = pay_date;
	}

    
}

package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.EmployeesEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Integer> {

    EmployeesEntity findByEmail(String email);
}

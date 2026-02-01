package com.example.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.entity.PayrollsEntity;

public interface PayrollsRepository extends JpaRepository<PayrollsEntity, Integer> {

    	// Net salary filter
		@Query(
	        value = "SELECT * FROM payrolls WHERE net_salary BETWEEN :min AND :max",
	        nativeQuery = true
	    )
	    List<PayrollsEntity> findPayrollsByNetSalaryRange(
	            @Param("min") double min,
	            @Param("max") double max
	    );
		
		List<PayrollsEntity> findAllByOrderByNet_salaryAsc();
		List<PayrollsEntity> findAllByOrderByNet_salaryDesc();
}
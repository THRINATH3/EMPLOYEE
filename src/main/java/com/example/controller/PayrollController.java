package com.example.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PayrollsEntity;
import com.example.repository.PayrollsRepository;

@RestController
@RequestMapping("/payrolls")
public class PayrollController {
	
	private final PayrollsRepository payrollsRepository;
	
	public PayrollController(PayrollsRepository payrollsRepository) {
        this.payrollsRepository = payrollsRepository;
    }
	
	// Net salary filter
	@GetMapping("/net-salary")
	public List<PayrollsEntity> filterByNetSalary(
	        @RequestParam double min,
	        @RequestParam double max) {
	    return payrollsRepository.findPayrollsByNetSalaryRange(min, max);
	}


}

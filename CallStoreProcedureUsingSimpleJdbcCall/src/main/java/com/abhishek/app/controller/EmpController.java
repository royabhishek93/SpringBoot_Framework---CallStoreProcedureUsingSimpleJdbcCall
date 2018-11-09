package com.abhishek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.app.model.Employee;
import com.abhishek.app.service.EmployeeService;

@RestController
public class EmpController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/findEmployeeDetailsById/{empId}")
	public Employee findEmployeeDetailsById(@PathVariable("empId") int empId) {
		return employeeService.fetchEmployeeNameAndSalaryById(empId);
		
	}
}

package com.abhishek.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.app.dao.EmployeeDAO;
import com.abhishek.app.model.Employee;
import com.abhishek.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public Employee fetchEmployeeNameAndSalaryById(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeNameAndSalaryById(employeeId);
		
	}

}

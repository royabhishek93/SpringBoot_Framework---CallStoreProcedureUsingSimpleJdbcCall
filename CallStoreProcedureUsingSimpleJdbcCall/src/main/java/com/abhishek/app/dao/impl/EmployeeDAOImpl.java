package com.abhishek.app.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.abhishek.app.dao.EmployeeDAO;
import com.abhishek.app.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	//@Autowired
	//private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired   
    private JdbcTemplate jdbcTemplate;
	
    
    
	@Override
	public Employee getEmployeeNameAndSalaryById(int employeeId) {
		// TODO Auto-generated method stub
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withProcedureName("getEmployeeNameAndSalaryById");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("empId", employeeId);
		
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		
		Map<String , Object> outMap=simpleJdbcCall.execute(in);
		
		Employee employee= new Employee();
		//System.out.println("outMap  "+outMap +"  empName  "+outMap.get("empName")+"empSal  "+outMap.get("empSal"));
		employee.setEmployeeName((String)outMap.get("empname"));
		employee.setSalary((Double)outMap.get("empsal"));
		return employee;
	}

}

package com.employee.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.ws.Exception.FailedToAddEmployeeException;
import com.employee.ws.entity.Employee;
import com.employee.ws.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/add")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		System.out.println("Employee received: " + employee);
		try {
		Employee newEmployee = employeeService.addNewEmployee(employee);
		return newEmployee;
		}catch(Exception e) {
			throw new FailedToAddEmployeeException("Some error occured while adding a new employee");
		}

	}
}

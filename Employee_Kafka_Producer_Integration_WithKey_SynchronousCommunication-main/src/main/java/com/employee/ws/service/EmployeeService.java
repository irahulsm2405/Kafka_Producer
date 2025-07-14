package com.employee.ws.service;

import org.springframework.stereotype.Service;

import com.employee.ws.entity.Employee;


public interface EmployeeService {
		public Employee addNewEmployee(Employee employee) throws Exception;
}

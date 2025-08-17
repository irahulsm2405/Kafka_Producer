package com.employee.ws.service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.ws.entity.Employee;
import com.employee.ws.kafka.KafkaProducerService;
import com.employee.ws.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	KafkaProducerService kafkaProducerService;
	
	@Override
	public Employee addNewEmployee(Employee employee) throws InterruptedException, ExecutionException {
		
		Employee newEmployee = employeeRepository.save(employee);
		
	//Kafka code here
	kafkaProducerService.sendEmployeeEvent(newEmployee);
	
	return newEmployee;
	}

}

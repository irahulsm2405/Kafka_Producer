package com.employee.ws.kafka;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.employee.ws.entity.Employee;

@Service
public class KafkaProducerService {
	
	//created a local variable with topic name
	public static final String TOPIC = "new-employee-created-event";
	
	@Autowired
	KafkaTemplate<String, Employee> kafkaTemplate;
	
	public void sendEmployeeEvent(Employee employe) {
		kafkaTemplate.send(TOPIC, employee);
	}
	
	
}

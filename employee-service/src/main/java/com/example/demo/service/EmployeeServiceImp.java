package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImp implements EmployeeService{

	private final EmployeeRepository er;

	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		return er.save(employee);
	}
	
}

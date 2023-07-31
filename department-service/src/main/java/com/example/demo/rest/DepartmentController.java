package com.example.demo.rest;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentSer;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

	private final DepartmentSer ds;
	private final Environment environment;
	@GetMapping("/status")
	public String status() {
		return "department-service is up and runing on port" + environment.getProperty("local.server.port");
	}
	
	@GetMapping("/{departmentName}")
	public Department findByName(@PathVariable("departmentName") String departmentName)
	{
		return ds.findDepartmentByName(departmentName);
	}
}

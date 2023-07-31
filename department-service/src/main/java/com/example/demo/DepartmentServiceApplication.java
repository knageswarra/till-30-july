package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableEurekaClient
@SpringBootApplication
public class DepartmentServiceApplication implements CommandLineRunner{

	private final DepartmentRepository dr;
	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dr.save(new Department("Sales", "Hyderabad"));
		dr.save(new Department("IT", "Banglore"));
		dr.save(new Department("Operations", "chennai"));
	}

}

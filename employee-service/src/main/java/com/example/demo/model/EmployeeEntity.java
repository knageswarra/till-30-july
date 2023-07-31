package com.example.demo.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee_table")
public class EmployeeEntity {

	@Id
	@Column(name = "e_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeid;

	private String employeeName;
	@Column(name = "department_id")
	private int departmentId;
	@Column(name = "department_name")
	private String departmentName;
}

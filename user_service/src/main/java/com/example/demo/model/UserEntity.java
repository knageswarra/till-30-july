package com.example.demo.model;


import lombok.*;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;




import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;
@NoArgsConstructor

@AllArgsConstructor

@Data

@Entity

public class UserEntity {

private String userId;

@Id

@GeneratedValue(strategy = GenerationType.AUTO)

private int id;

private String firstName;

private String lastName;

private String email;

private String password;

private String encryptedPassword;

@Override
public String toString() {
	return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", password=" + password+"]";
}

}
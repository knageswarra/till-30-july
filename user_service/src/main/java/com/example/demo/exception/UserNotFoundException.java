package com.example.demo.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserNotFoundException extends Exception{

	
	private static final long serialVersionUID = 1L;
	private String message;

}

package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserEntity;
import com.example.demo.service.UserEntitySer;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserEntityController {
	private final UserEntitySer usr;
	private final ModelMapper modelMapper;

	
	private Environment environment;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("service is runing on port: "+environment.getProperty("local.server.port"));
	}
	@PostMapping
	public ResponseEntity<UserResponseModel> createEmployee(@RequestBody UserRequestModel userRequestModel) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		UserEntity userEntity = usr.create(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userEntity, UserResponseModel.class));
	}

	@GetMapping
	public ResponseEntity<List<UserResponseModel>> getEmployees() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserEntity> list=usr.listAll();
		List<UserResponseModel> userResponseModels=new ArrayList<UserResponseModel>();
		for(UserEntity u:list)
		{
			userResponseModels.add(modelMapper.map(u, UserResponseModel.class));
		}
		return ResponseEntity.status(HttpStatus.OK).body(userResponseModels);
	}
	@GetMapping("/{userid}")
	public ResponseEntity<UserResponseModel> findUserById(@PathVariable("userid") String userId) throws UserNotFoundException
	{
		UserEntity ue=usr.findByUserId(userId);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		if (ue == null) {
			throw new UserNotFoundException("user with " + userId + " not found");
		} else {
			return ResponseEntity.ok(modelMapper.map(ue, UserResponseModel.class));
		}
	}

}

package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserEntity;

public interface UserEntitySer {
	UserEntity create(UserDto ue);
	List<UserEntity> listAll();
	UserEntity findByUserId(String userId);

}

package com.example.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repo.UserEntityRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserEntitySerImp implements UserEntitySer {

	private final ModelMapper modelMapper;
	private final UserEntityRepository usr;
	
	
	public UserEntity create(UserDto userDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		StringBuffer sb = new StringBuffer();
		sb.append(userDto.getPassword());
		userEntity.setEncryptedPassword(sb.reverse().toString());
		return usr.save(userEntity);
	}

	@Override
	public List<UserEntity> listAll() {
		// TODO Auto-generated method stub
		return usr.findAll();
	}

	@Override
	public UserEntity findByUserId(String userId) {
		return usr.findByUserId(userId);
	}

}

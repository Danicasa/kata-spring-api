package com.kata.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.kata.model.domain.Kata;
import com.kata.model.domain.User;
import com.kata.model.response.KataResponse;
import com.kata.model.response.UserResponse;
import com.kata.repository.CategoryRepository;
import com.kata.repository.KataRepository;
import com.kata.repository.UserRepository;

public class CategoryMapper {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KataRepository kataRepository;
	
	public User mapperUserToUserResponse(UserResponse userResponse) {
		User user = new User();
		if(userResponse.getIduser() != null) {
			user = userRepository.findById(userResponse.getIduser()).get();
		}
		
		user.setEmail(userResponse.getEmail());
		user.setGitUrl(userResponse.getGitUrl());
		user.setName(userResponse.getName());
		
		return user;
	}
	
	public KataResponse mapperUserResponseToUser(Kata kata) {
		return new KataResponse();
	}
	

}

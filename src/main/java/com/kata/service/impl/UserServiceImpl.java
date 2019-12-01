package com.kata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.domain.User;
import com.kata.repository.UserRepository;
import com.kata.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Boolean saveUser(User user) {
		
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public User getById(Integer idUser) {	
		return userRepository.getOne(idUser);
	}

}

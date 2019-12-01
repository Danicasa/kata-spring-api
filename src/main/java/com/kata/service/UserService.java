package com.kata.service;

import com.kata.model.domain.User;

public interface UserService {
	
	public Boolean saveUser(User user);

	public User getById(Integer idUser);

}

package com.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.model.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

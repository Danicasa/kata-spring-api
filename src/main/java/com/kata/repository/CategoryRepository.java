package com.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.model.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

package com.kata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.domain.Category;
import com.kata.repository.CategoryRepository;
import com.kata.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Boolean saveCategory(Category category) {
		
		try {
			categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Category getById(Integer idCategory) {
		return categoryRepository.getOne(idCategory);
	}

}

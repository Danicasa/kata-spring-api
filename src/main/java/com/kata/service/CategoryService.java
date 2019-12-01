package com.kata.service;

import com.kata.model.domain.Category;

public interface CategoryService {
	
	public Boolean saveCategory(Category category);
	public Category getById(Integer idCategory);

}

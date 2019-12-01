package com.kata.service;

import java.util.List;

import com.kata.model.domain.Kata;

public interface KataService {
	
	public List<Kata> getAllKatas();
	public Boolean saveKata(Kata kata);
	public Kata findById(Integer idKata);
	public List<Kata> findAllByCategory(Integer idCategory);
	public Boolean existsById(Integer idKata);
	public void deleteById(Integer idKata);

}

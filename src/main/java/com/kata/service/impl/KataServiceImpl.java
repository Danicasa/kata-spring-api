package com.kata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.model.domain.Kata;
import com.kata.repository.KataRepository;
import com.kata.service.KataService;

@Service
public class KataServiceImpl implements KataService {

	@Autowired
	private KataRepository kataRepository;

	@Override
	public List<Kata> getAllKatas() {
		return kataRepository.findAll();
	}

	@Override
	public Boolean saveKata(Kata kata) {
		try {
			kataRepository.save(kata);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Kata findById(Integer idKata) {
		return kataRepository.findById(idKata).get();
	}

	@Override
	public List<Kata> findAllByCategory(Integer idCategory) {
		return kataRepository.findAllByCategory(idCategory);
	}

	@Override
	public Boolean existsById(Integer idKata) {
		return kataRepository.existsById(idKata);
	}

	@Override
	public void deleteById(Integer idKata) {
		kataRepository.deleteById(idKata);
	}

}

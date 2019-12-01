package com.kata.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kata.model.domain.Kata;
import com.kata.model.response.CategoryResponse;
import com.kata.model.response.KataResponse;
import com.kata.model.response.UserResponse;
import com.kata.repository.CategoryRepository;
import com.kata.repository.KataRepository;
import com.kata.repository.UserRepository;

public class KataMapper {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KataRepository kataRepository;
	
	public Kata mapperKataResponseToKata(KataResponse kataResponse) {
		Kata kata = new Kata();
		if(kataResponse.getIdkata() != null) {
			kata = kataRepository.findById(kataResponse.getIdkata()).get();
		}

		kata.setUserIduser(userRepository.findById(kataResponse.getUserIduser().getIduser()).get());
		kata.setCategoryIdcategory(categoryRepository.findById(kataResponse.getCategoryIdcategory().getIdcategory()).get());
		
//		kata.setDescription(kataResponse.getDescription());
//		kata.setGitUrl(kataResponse.getGitUrl());
//		kata.setTitle(kataResponse.getTitle());
		
		setKataDetailsFromKataResponse(kata, kataResponse);
		
		return kata;
	}
	
	public List<KataResponse> mapperKatasToKatasResponse(List<Kata> katas){
		List<KataResponse> katasResponse = new ArrayList<KataResponse>();
		for(Kata kata : katas) {
			katasResponse.add(this.mapperKataToKataResponse(kata));
		}
		return katasResponse;
	}
	
	public KataResponse mapperKataToKataResponse(Kata kata) {
		
		KataResponse kataResponse = new KataResponse();
		
		kataResponse.setIdkata(kata.getIdkata());
		
		kataResponse.setCategoryIdcategory(
				new CategoryResponse(kata.getCategoryIdcategory().getIdcategory(),
						kata.getCategoryIdcategory().getDescription()));
		
		kataResponse.setUserIduser(
				new UserResponse(kata.getUserIduser().getIduser(),
						kata.getUserIduser().getEmail(), 
						kata.getUserIduser().getName(),
						kata.getUserIduser().getGitUrl()));
		
//		kataResponse.setDescription(kata.getDescription());
//		kataResponse.setGitUrl(kata.getGitUrl());
//		kataResponse.setTitle(kata.getTitle());
		
		setKataDetailsFromKata(kata, kataResponse);
		
		return kataResponse;
	}
	
	public Kata setKataDetailsFromKataResponse(Kata kata, KataResponse kataResponse) {
		kata.setDescription(kataResponse.getDescription());
		kata.setGitUrl(kataResponse.getGitUrl());
		kata.setTitle(kataResponse.getTitle());
		
		return kata;
	}
	
	public KataResponse setKataDetailsFromKata(Kata kata, KataResponse kataResponse) {
		kataResponse.setDescription(kata.getDescription());
		kataResponse.setGitUrl(kata.getGitUrl());
		kataResponse.setTitle(kata.getTitle());
		
		return kataResponse;
	}
	
}

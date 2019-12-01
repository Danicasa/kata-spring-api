package com.kata.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kata.model.domain.Category;
import com.kata.model.domain.Kata;
import com.kata.model.domain.User;
import com.kata.model.mapper.KataMapper;
import com.kata.model.response.KataResponse;
import com.kata.service.CategoryService;
//import com.kata.repository.CategoryRepository;
//import com.kata.repository.UserRepository;
import com.kata.service.KataService;
import com.kata.service.UserService;

@RestController
@RequestMapping(KataController.API_ROOT_RESOURCE)
@CrossOrigin
public class KataController {

	public static final String API_ROOT_RESOURCE = "/kata";

	@Autowired
	private KataService kataService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	private KataMapper kataMapper = new KataMapper();

	@CrossOrigin
	@GetMapping("getAllKatas")
	public ResponseEntity<List<KataResponse>> getAll(HttpServletRequest request) {	
		List<Kata> katas = kataService.getAllKatas();
		List<KataResponse> katasResponse = kataMapper.mapperKatasToKatasResponse(katas);
		return new ResponseEntity<List<KataResponse>>(katasResponse, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("getKataById/{id}")
	public ResponseEntity<KataResponse> getKataById(@Valid @PathVariable("id") Integer id, HttpServletRequest request) {
		Kata kata = kataService.findById(id);
		KataResponse kataResponse = kataMapper.mapperKataToKataResponse(kata);
		return new ResponseEntity<KataResponse>(kataResponse, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("getAllKatasByCategory/{idCategory}")
	public ResponseEntity<List<KataResponse>> getAllByCategory(@Valid @PathVariable("idCategory") Integer id,
			HttpServletRequest request) {
		List<Kata> katas = kataService.findAllByCategory(id);
		List<KataResponse> katasResponse = kataMapper.mapperKatasToKatasResponse(katas);
		return new ResponseEntity<List<KataResponse>>(katasResponse, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("saveKata")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> save(@Valid @RequestBody KataResponse kataDetails, HttpServletRequest request,
			HttpServletResponse response) {

		Kata kata = new Kata(kataDetails.getTitle(), kataDetails.getGitUrl(), kataDetails.getDescription());

		Category category = categoryService.getById(kataDetails.getCategoryIdcategory().getIdcategory());			
		kata.setCategoryIdcategory(category);

		User user = userService.getById(kataDetails.getUserIduser().getIduser());
		kata.setUserIduser(user);

		kataService.saveKata(kata);
		
		return ResponseEntity.ok("Kata is valid");

	}

	@CrossOrigin
	@PostMapping("updateKata")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateKata(@Valid @RequestBody KataResponse kataDetails) {

		Kata kata = kataService.findById(kataDetails.getIdkata());	
		kataMapper.setKataDetailsFromKataResponse(kata, kataDetails);
		
		Category category = categoryService.getById(kataDetails.getCategoryIdcategory().getIdcategory());			
		kata.setCategoryIdcategory(category);

		User user = userService.getById(kataDetails.getUserIduser().getIduser());
		kata.setUserIduser(user);

		return ResponseEntity.ok("Kata update is valid");
	}

	@CrossOrigin
	@GetMapping("deleteKata/{id}")
	public Map<String, Boolean> update(@PathVariable("id") Integer idKata) throws Exception {

//		kataRepository.findById(kataId)
//				.orElseThrow(() -> new ResourceNotFoundException("Kata not found on :: " + kataId));
		Map<String, Boolean> response = new HashMap<>();
		
		if(!kataService.existsById(idKata)) {
			response.put("deleted", Boolean.FALSE);
		}
				
		kataService.deleteById(idKata);
		response.put("deleted", Boolean.TRUE);

		return response;
	}

}

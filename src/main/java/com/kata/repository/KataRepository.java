package com.kata.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kata.model.domain.Kata;

public interface KataRepository extends JpaRepository<Kata, Integer> {
	
	@Query("SELECT k FROM Kata k join fetch k.categoryIdcategory c WHERE c.idcategory = :idCategory")
	List<Kata> findAllByCategory(@Param("idCategory") Integer idCategory);
	
}

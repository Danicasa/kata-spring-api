package com.kata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kata.api.controller.KataController;

@SpringBootTest
class KataAuthApiApplicationTests {

	@Autowired
    private KataController kataController;
	
	@Autowired
    private KataController UserController;
	
	@Test
	void contextLoads() {
		assertThat(kataController).isNotNull();
		assertThat(UserController).isNotNull();
	}
		
}

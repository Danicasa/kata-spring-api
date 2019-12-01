package com.kata.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserController.API_ROOT_RESOURCE)
@CrossOrigin
public class UserController {

	public static final String API_ROOT_RESOURCE = "/user";

}

package com.was.udemyrestfull.restfull.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
	
	@RequestMapping("/hello")
	public String hellow() {
		return "hello";
	}

}

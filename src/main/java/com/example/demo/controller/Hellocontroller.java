package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hellocontroller {
	
	@GetMapping("/")
	public String index() {
		return "Geeting from sping Boot!";
	}

}

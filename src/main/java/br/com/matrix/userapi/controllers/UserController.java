package br.com.matrix.userapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/")
	public String getMessagem() {
		return "Spring boot is working!";
	}
}

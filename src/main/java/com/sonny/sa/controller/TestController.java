package com.sonny.sa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class TestController {

	@GetMapping("string")
	public String getString() {
		return "<h1>Chaine de caracteres transmise par SA</h1>";

	}
	
	@GetMapping
	public List<String> getList() {
		return List.of("Chaine de caracteres", "transmise par SA");
	}
}

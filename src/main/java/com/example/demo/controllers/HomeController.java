package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "<h1>Hello World</h1>";
	}

	@GetMapping("/contatos/{nome}")
	public String contatos(@PathVariable("nome") String nome) {
		return "Contatos: " + nome;
	}
}

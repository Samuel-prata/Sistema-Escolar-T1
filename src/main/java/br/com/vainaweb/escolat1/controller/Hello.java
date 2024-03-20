package br.com.vainaweb.escolat1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Hello {
	
	@GetMapping
	public String saudacao(@RequestParam(defaultValue = "World", name = "nome") String nome ) {
		return "Hello, " + nome;
	}
	

	
}

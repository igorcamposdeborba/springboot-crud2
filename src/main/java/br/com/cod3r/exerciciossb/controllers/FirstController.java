package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	// @GetMapping(value = {"/ola", "/hello"}) // alternativa de endpoint com método mais específico e mais usado
	@RequestMapping(method = RequestMethod.GET, value = {"/ola", "/hello"})
	public String hello() {
		return "Olá SpringBoot";
	}

}

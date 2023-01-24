package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methods")
public class MethodsHttpController {

	@GetMapping (path = "/get")
	public String get() {
		return "Requisição get";
	}
	
	@PostMapping(path = "/post")
	public String post(){
		return "Requisição post";
	}
	
	@PutMapping(path = "/put")
	public String put() {
		return "Requisição put";
	}
	
	@PatchMapping(path = "/patch")
	public String path() {
		return "Requisição patch";
	}
	
	@DeleteMapping(path = "/delete")
	public String delete() {
		return "Requisição delete";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

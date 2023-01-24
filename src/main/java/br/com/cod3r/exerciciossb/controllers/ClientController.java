package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Client;

@RestController
public class ClientController {
	
	@GetMapping(path = "/clients/any")
	public Client getClient() {
		return new Client(28, "Igor", "012.345.678-00");
	}
	
	// requisição na URI
	@GetMapping("/clients/{id}")
	public Client getClientById(@PathVariable int id) {
		return new Client(id, "Igor", "524.489.467.20");
	}
	
	// requisição como UTM
	@GetMapping("/clients")
	public Client getClientByIdParam(@RequestParam(name = "id") int id) {
		return new Client(id, "Luana", "123.456.789.10");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

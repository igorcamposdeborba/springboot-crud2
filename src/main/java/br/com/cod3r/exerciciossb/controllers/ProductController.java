package br.com.cod3r.exerciciossb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Product;
import br.com.cod3r.exerciciossb.model.repositories.ProductRepository;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping
	public @ResponseBody Product newProduct(@RequestParam String name) { // body da resposta do servidor (Product) e body da requisição
		Product product = new Product(name);
		
		productRepository.save(product);
		
		return product;
	}
	
}

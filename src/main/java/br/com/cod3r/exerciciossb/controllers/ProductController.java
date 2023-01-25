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
	
	@Autowired // @Autowired instancia objeto para que eu possa usar o método de salvar o registro no banco de dados. Isso via injeção de dependência
	private ProductRepository productRepository; 
	
	@PostMapping
	public @ResponseBody Product newProduct(@RequestParam String name, @RequestParam Double price) { // body da resposta do servidor (Product) e body da requisição
		Product product = new Product(name, price);
		
		productRepository.save(product); // salvar produto no banco de dados. save é um método do CrudRepository no ProductRepository
		
		return product;
	}
	
	@PostMapping (path = "/discount{percentage}")
	public @ResponseBody Product newProduct(@RequestParam String name, @RequestParam Double price, @RequestParam(name = "percentage") Double discount) {
		Product product = new Product(name, price, discount);
		
		product.setDiscount(discount);
		productRepository.save(product);
		
		return product;
	}
	
}

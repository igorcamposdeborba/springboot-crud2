package br.com.cod3r.exerciciossb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Product;
import br.com.cod3r.exerciciossb.model.repositories.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {
	
	@Autowired // @Autowired instancia objeto para que eu possa usar o método de salvar o registro no banco de dados. Isso via injeção de dependência
	private ProductRepository productRepository; 
	
	@PostMapping
	public @ResponseBody Product newProduct(@Valid Product product) { // body da resposta do servidor (Product) e body da requisição. @Valid aceita só objeto com atributos válidos segundo as annotations da classe Product
		productRepository.save(product); // salvar produto no banco de dados. save é um método do CrudRepository no ProductRepository
		return product;
	}
	
	@PostMapping (path = "/discount{name}")
	public @ResponseBody Product newProduct(@RequestParam(value = "name") String name, @RequestParam Double price, @RequestParam Double discount) {
		Product product = new Product(name, price, discount);
		
		product.setDiscount(discount);
		productRepository.save(product);
		
		return product;
	}
	
	@GetMapping (path = "/find-all")
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	@GetMapping (path = "/page{pageNumber}{quantityPerPage}")
	public Iterable<Product> getProductByPage(@RequestParam(value = "pageNumber") int pageNumber, @RequestParam(value = "quantityPerPage") int quantityPerPage){
		if (quantityPerPage > 100) {
			quantityPerPage = 5;
		}
		
		Pageable page = PageRequest.of(pageNumber, quantityPerPage);
		return productRepository.findAll(page);
	}
	
	@GetMapping (path = "/find-by-id{id}")
	public Optional<Product> findById(@RequestParam(name = "id") Integer id) {
		return productRepository.findById(id);
	}
	
	@PutMapping (path = "/update-by-id")
	public Product update(@RequestParam String name, @RequestParam Double price, @RequestParam Double discount, @RequestParam Integer id) {
		Product product = new Product(name, price, discount, id);
		
		productRepository.save(product);
		
		return product;
	}
	
	@DeleteMapping (path = "/delete")
	public void delete(@RequestParam(name = "id") Integer id) {
		productRepository.deleteById(id);
	}
	
	@GetMapping (path = "/find-by-name{partName}")
	public Iterable<Product> findProductsByName(@RequestParam(value = "partName") String partName){
		return productRepository.findByNameContainingIgnoreCase(partName);
	}
	
}

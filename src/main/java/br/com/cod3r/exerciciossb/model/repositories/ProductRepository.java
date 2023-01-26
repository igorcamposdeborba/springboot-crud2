package br.com.cod3r.exerciciossb.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.cod3r.exerciciossb.model.entities.Product;

// interface repository abstrai o acesso aos dados por meio de injeção de dependência para que eu possa acessar os métodos de um CRUD
public interface ProductRepository extends CrudRepository<Product, Integer>, PagingAndSortingRepository <Product, Integer>{
	
	public Iterable<Product> findByNameContainingIgnoreCase(String partName);
	
}

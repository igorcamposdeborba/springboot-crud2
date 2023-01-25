package br.com.cod3r.exerciciossb.model.entities;


import java.util.Objects;

import br.com.cod3r.exerciciossb.model.services.PatternService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity // obrigatório
@Table(name = "product")
public class Product {
	
	@Id // obrigatório
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Identity: id tem sequência única de id
	private Integer id;
	
	@NotBlank
	private String name;
	
	@Min(value = 0)
	private Double price;
	
	@Min(value = 0)
	@Max(value = 1)
	private Double discount;
	
	public Product() {}
	public Product(String name) {
		this.name = name;
	}
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	public Product(String name, Double price, Double discount) {
		PatternService.validateTypeDouble(discount);
		
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	public Product(String name, Double price, Double discount, Integer id) {
		this(name, price, discount);
		this.id = id;
	}
	
	// Access methods
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	// Logic methods	
	public void setDiscount(Double discount) {		
		price -= price * discount;
	}
	
}

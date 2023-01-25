package br.com.cod3r.exerciciossb.model.entities;


import java.io.Serializable;
import java.util.Objects;

import br.com.cod3r.exerciciossb.model.services.PatternService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // obrigatório
@Table(name = "product")
public class Product {
	
	@Id // obrigatório
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Identity: id tem sequência única de id
	private Integer id;
	private String name;
	private Double price;
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
		validatePrice(price);
		// validateDiscount(discount);
		// setDiscount(discount);
		
		this.name = name;
		this.price = price;
		this.discount = discount;
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
		double result = validatePrice(price);
		this.price = result;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	// Logic methods
	public Double validatePrice(Double price) {
		return price > 0 ? price : null;
	}
	
	public Double validateDiscount(Double discount) {
		Double discountFormatted = PatternService.validateTypeDouble(discount);
		
		Double discountResult = 0.0;
		
		if (discountFormatted >= 0.0 && discountFormatted <= 1.0) {
			discountResult = discountFormatted;
		}
		return discountResult;
	}
	
	public void setDiscount(Double discount) {
		Double discountValidated = validateDiscount(discount);
		
		price -= price * discount;
	}
	
}

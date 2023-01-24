package br.com.cod3r.exerciciossb.model.entities;


import java.io.Serializable;
import java.util.Objects;

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
	
	public Product() {}
	public Product(String name) {
		this.name = name;
	}
	
	// Access methods
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
}

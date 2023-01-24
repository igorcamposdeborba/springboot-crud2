package br.com.cod3r.exerciciossb.model.entities;

public class Client {
	private int id;
	private String name, cpf;
	
	public Client() {}
	
	public Client (int id, String name, String cpf) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

package com.provaAdriano.pratica.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //define que isso vai se tornar uma tabela no banco
@Table(name = "tabela_user") //define o nome da tabela
@Data //anotação do lombok que faz com que não seja necessário criar getters e setters
public class User {
	@Id //o atributo que vem embaixo dessa anotação será a chave primária da tabela
	@GeneratedValue(strategy=GenerationType.IDENTITY) //define que a chave primária será auto incrementável
	private Long id;
	
	@Column(length=150) //a coluna nome do banco não pode estar vazia e tem no máximo 150 caracteres
	private String name;
	
	@Column(unique=true) // a coluna cpf não pode ser nula e também não pode haver dois usuários com o mesmo cpf
	private String cpf; 
	
	private String email;
	
	//métodos construtores
	public User() {}
	public User(String name, String cpf, String email) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
	}
	
	

//  GETTERS E SETTERS
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getCpf() {
//		return cpf;
//	}
//	public void setCpf(String cpf) {
//		this.cpf = cpf;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	
	
}

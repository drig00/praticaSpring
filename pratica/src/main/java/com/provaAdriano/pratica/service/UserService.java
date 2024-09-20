package com.provaAdriano.pratica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provaAdriano.pratica.model.User;
import com.provaAdriano.pratica.repository.UserRepository;

@Service //define que isso é um serviço
public class UserService {

	@Autowired //sereve para injetar dependências. O que é isso? não sei, explique ai mestre raphael
	UserRepository repository;
	
	//salvar um objeto do tipo User
	public User saveUser(User user) {
		return repository.save(user);	
	}
	
	//deletar um User baseado no "id" que é passado
	public void deleteUser(long id) {
		repository.deleteById(id);
	}
	
	//lista todos os objetos User que existirem
	public List<User> listeTodos(){
		return repository.findAll();
	}
}

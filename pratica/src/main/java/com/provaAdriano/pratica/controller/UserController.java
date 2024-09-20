package com.provaAdriano.pratica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.provaAdriano.pratica.model.User;
import com.provaAdriano.pratica.service.UserService;

@RestController //define que isso é um controlador
@RequestMapping("/pratica") //é como se fosse o nome da aplicação, todas as rotas vão ter que começar com /pratica
public class UserController {
	@Autowired
	UserService service; //é um objeto da classe UserService, precisa dele pra poder usar os métodos que estão dentro da classe service
	
	@GetMapping("/listaTodos") // quando for passado GET http://localhost:8080/pratica/listaTodos esse método vai ser ativado
	public List<User> listarTodos(){
		return service.listeTodos();
	}
	
	@PostMapping("/adicionarUser") // quando for passado POST http://localhost:8080/pratica/adicionarUser esse método vai ser ativado
	public User adicionarUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	/*
	 * RequestBody é uma anotação que serve para indicar onde vai estar o objeto do tipo User que será posto no banco,
	 * até porque não faz sentido chamar um método para postar algum usuário no banco e não passar o usuário
	 */
	
	@DeleteMapping("/deletarUser/{id}") //quando for passado DELETE http://localhost:8080/pratica/deleteUser/{número de id} esse método vai ser ativado
	public void deletarUser(@PathVariable long id) {
		service.deleteUser(id);
	}
	/*
	 * Não faz sentido eu pedir no método para deletar um usuário se ele não souber quem é o usuário que ele vai deletar
	 * pra ele identificar o usuário que vai ser deletado eu to passando o id do usuário já que não existem usuários com
	 * ids iguais, então não tem como ele se confundir com quem deletar
	 * */
	
	/*
	 * a anotação @PathVariable só tá indicando onde que está o id do usuário que ele vai usar para deletar do banco.
	 * no caso o id vai ser passado no caminho(http://localhost:8080/pratica/deleteUser/{número de id})
	 * */
}

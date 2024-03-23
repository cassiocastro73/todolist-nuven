package com.castrodev.desafioToDoList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.castrodev.desafioToDoList.entity.Todo;
import com.castrodev.desafioToDoList.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
	this.todoService = todoService;
    }

    @PostMapping("/create")
    List<Todo> create(@RequestBody Todo todo) {
	if (todo.getTitulo().trim()== null || todo.getTitulo().trim() == "") {
	    throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "O título da tarefa não pode ser nulo");
	} else if (todo.getDescricao().trim() == null  || todo.getDescricao().trim() == "") {
	    throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "A descrição da tarefa não pode ser nulo");
	} else if (todo.getVencimento().trim() == null || todo.getVencimento().trim() == "") {
	    throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "O vencimento da tarefa não pode ser nulo");
	} else {
	    return todoService.create(todo);
	}

    }

    @GetMapping
    List<Todo> list() {
	return todoService.list();
    }

    @PutMapping("/update/{id}")
    List<Todo> update(@RequestBody Todo todo, @PathVariable("id") Long id) {
	if (todo.getTitulo() == null && todo.getDescricao() == null && todo.getVencimento() == null) {
	    throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "Não é possível cadastrar tarefas sem informação");
	}else {
	    return todoService.update(todo, id);
	}
	
    }

    @DeleteMapping("/delete/{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
	return todoService.delete(id);
    }

}

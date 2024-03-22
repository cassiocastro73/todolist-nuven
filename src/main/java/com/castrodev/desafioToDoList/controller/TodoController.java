package com.castrodev.desafioToDoList.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return todoService.create(todo);
	}

	@GetMapping
	List<Todo> list() {
		return todoService.list();
	}

	@PutMapping("/update/{id}")
	List<Todo> update(@RequestBody Todo todo, @PathVariable("id") Long id) {
		return todoService.update(todo, id);
	}

	@DeleteMapping("/delete/{id}")
	List<Todo> delete(@PathVariable("id") Long id) {
		return todoService.delete(id);
	}

}

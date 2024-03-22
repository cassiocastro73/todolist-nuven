package com.castrodev.desafioToDoList.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.castrodev.desafioToDoList.entity.Todo;
import com.castrodev.desafioToDoList.repository.TodoRepository;

@Service
public class TodoService {
	
	private TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> create(Todo todo) {
		todoRepository.save(todo);
		return list();
	}

	public List<Todo> list() {
		Sort sort = Sort.by("vencimento").ascending().and(Sort.by("titulo"));
		return todoRepository.findAll(sort);
	}

	public List<Todo> update(Todo todo, Long id) {
		Todo todoAtual = todoRepository.findById(id).get();
		todoAtual.setDescricao(todo.getDescricao());
		todoAtual.setTitulo(todo.getTitulo());
		todoAtual.setVencimento(todo.getVencimento());
		todoRepository.save(todoAtual);
		return list();
	}

	public List<Todo> delete(Long id) {
		todoRepository.deleteById(id);;
		return list();
	}
}

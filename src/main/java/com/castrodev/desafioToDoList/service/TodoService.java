package com.castrodev.desafioToDoList.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
	if (todo.getTitulo().trim() == null || todo.getTitulo().trim() == "") {
	    throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "O Título da tarefa não pode ser nulo");
	}else {
	    todoAtual.setTitulo(todo.getTitulo());
	}
	if (todo.getDescricao().trim() == null || todo.getDescricao().trim() == "") {
	    throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "A Descrição da tarefa não pode ser nulo");
	}else {
	    todoAtual.setDescricao(todo.getDescricao());
	}
	if (todo.getVencimento().trim() == null || todo.getVencimento().trim() == "") {
	    throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "O vencimento da tarefa não pode ser nulo");	   
	}else {
	    todoAtual.setVencimento(todo.getVencimento());
	}

	todoRepository.save(todoAtual);
	return list();
    }

    public List<Todo> delete(Long id) {
	try {
	    todoRepository.deleteById(id);
	}catch (Exception e) {
	    throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Tarefa não cadastrada");
	}
	
	return list();
    }
}

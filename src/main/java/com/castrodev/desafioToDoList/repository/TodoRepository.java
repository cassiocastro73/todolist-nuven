package com.castrodev.desafioToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castrodev.desafioToDoList.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}

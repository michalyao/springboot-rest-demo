package me.yoryor.demo.service;

import me.yoryor.demo.entity.Todo;

import java.util.List;

public interface TodoService {
  List<Todo> findAll();

  Todo findById(int id);

  Todo save(Todo todo);

  boolean deleteById(int id);
}

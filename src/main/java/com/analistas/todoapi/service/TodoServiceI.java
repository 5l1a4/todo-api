package com.analistas.todoapi.service;

import com.analistas.todoapi.domain.dto.TodoRequest;
import com.analistas.todoapi.domain.dto.TodoResponse;

import java.util.List;

public interface TodoServiceI {

    List<TodoResponse> findAll();

    TodoResponse findById(Long id);

    TodoResponse save(TodoRequest todoRequest);

    TodoResponse update(TodoRequest todoRequest, Long id);

    void deleteById(Long id);

}

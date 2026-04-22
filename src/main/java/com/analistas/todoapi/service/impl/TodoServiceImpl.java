package com.analistas.todoapi.service.impl;

import com.analistas.todoapi.domain.dto.TodoRequest;
import com.analistas.todoapi.domain.dto.TodoResponse;
import com.analistas.todoapi.domain.entity.Todo;
import com.analistas.todoapi.domain.mapper.TodoMapper;
import com.analistas.todoapi.repository.TodoRepository;
import com.analistas.todoapi.service.TodoServiceI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoServiceI {

    public static final String ERROR_MESAGE = "Entidad no Encontrada";

    private final TodoRepository todoRepository;

    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoRepository todoRepository,  TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public List<TodoResponse> findAll() {
        List<TodoResponse> todoResponses = new ArrayList<>();
        List<Todo> todos = todoRepository.findAll();
        for (Todo todo: todos) {
            todoResponses.add(todoMapper.toResponse(todo));
        }
        return todoResponses;
    }

    @Override
    public TodoResponse findById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException(ERROR_MESAGE));
        TodoResponse response = todoMapper.toResponse(todo);
        return response;
    }

    @Override
    public TodoResponse save(TodoRequest todoRequest) {
        Todo todo = todoRepository.save(todoMapper.toEntity(todoRequest));
        TodoResponse response = todoMapper.toResponse(todo);
        return response;
    }

    @Override
    public TodoResponse update(TodoRequest request, Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException(ERROR_MESAGE));
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setDueDate(request.getDueDate());
        todoRepository.save(todo);
        TodoResponse response = todoMapper.toResponse(todo);
        return response;
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.findById(id).orElseThrow(() -> new RuntimeException(ERROR_MESAGE));
        todoRepository.deleteById(id);
    }

}

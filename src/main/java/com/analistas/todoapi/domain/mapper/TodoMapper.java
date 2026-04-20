package com.analistas.todoapi.domain.mapper;

import com.analistas.todoapi.domain.dto.TodoRequest;
import com.analistas.todoapi.domain.dto.TodoResponse;
import com.analistas.todoapi.domain.entity.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoResponse toResponse(Todo todo){

        TodoResponse todoResponse = new TodoResponse(
                todo.getIdTodo(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getCreationDate(),
                todo.getDueDate(),
                todo.getStatus()
        );

        return todoResponse;
    }

    public Todo toEntity(TodoRequest request){

        Todo todoEntity = new Todo();

        todoEntity.setTitle(request.getTitle());
        todoEntity.setDescription(request.getDescription());
        todoEntity.setDueDate(request.getDueDate());

        return todoEntity;

    }
}

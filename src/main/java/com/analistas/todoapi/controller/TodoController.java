package com.analistas.todoapi.controller;

import com.analistas.todoapi.domain.dto.TodoRequest;
import com.analistas.todoapi.domain.dto.TodoResponse;
import com.analistas.todoapi.service.TodoServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoServiceI todoService;

    public TodoController(TodoServiceI todoService){
        this.todoService = todoService;

    }

    @GetMapping("/")
    public ResponseEntity<List<TodoResponse>> getTodos(){
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id){
        return ResponseEntity.ok(todoService.findById(id));
    }

    @PutMapping("/created")
    public ResponseEntity<HttpStatus> createTodo(TodoRequest todoRequest){
        todoService.save(todoRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/updated/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, TodoRequest todoRequest){
        return ResponseEntity.ok(todoService.update(todoRequest, id));
    }

    @DeleteMapping("/removed/{id}")
    public ResponseEntity<String>(@PathVariable Long id){
        return ResponseEntity<"buenNivel">.ok
    }
}

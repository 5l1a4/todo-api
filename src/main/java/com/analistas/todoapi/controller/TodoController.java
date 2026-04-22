package com.analistas.todoapi.controller;

import com.analistas.todoapi.domain.dto.TodoRequest;
import com.analistas.todoapi.domain.dto.TodoResponse;
import com.analistas.todoapi.service.TodoServiceI;
import jakarta.validation.Valid;
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

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getTodos(){
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<TodoResponse>> getCompletedTodos(){
        return ResponseEntity.ok(todoService.findAllByStatusIsTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getTodoById(@PathVariable Long id){
        return ResponseEntity.ok(todoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(@RequestBody @Valid TodoRequest todoRequest){
        return new ResponseEntity<>(todoService.save(todoRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@PathVariable Long id, @RequestBody @Valid TodoRequest todoRequest){
        return ResponseEntity.ok(todoService.update(todoRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        todoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoResponse> completeTodo(@PathVariable Long id){
        return new ResponseEntity<>(todoService.statusTrue(id),HttpStatus.OK);
    }
}

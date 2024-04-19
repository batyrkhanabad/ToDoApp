package com.example.ToDoList.controller;

import com.example.ToDoList.model.dto.ToDoRequestDto;
import com.example.ToDoList.model.dto.ToDoResponseDto;
import com.example.ToDoList.model.entity.ToDo;
import com.example.ToDoList.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v5/todos")
public class ToDoController {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> findAll() {
        return toDoService.findAll();
    }

    @PostMapping
    public ToDoResponseDto createToDo(@RequestBody ToDoRequestDto toDoRequestDto) {
        return toDoService.createToDo(toDoRequestDto);
    }

    @PutMapping("/{id}")
    public ToDoResponseDto upDateToDo(@PathVariable Long id, @RequestBody ToDoRequestDto toDoDetails) {
        return toDoService.upDateToDo(id, toDoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
    }
}
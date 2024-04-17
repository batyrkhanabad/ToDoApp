package com.example.ToDoList.service;

import com.example.ToDoList.model.entity.ToDo;
import com.example.ToDoList.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo upDateToDo(Long id, ToDo todoDetails) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
        toDo.setTitle(todoDetails.getTitle());
        toDo.setDescription(todoDetails.getDescription());
        toDo.setDate(todoDetails.getDate());
        toDo.setStatus(todoDetails.isStatus());

        return toDoRepository.save(toDo);
    }

    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }
}
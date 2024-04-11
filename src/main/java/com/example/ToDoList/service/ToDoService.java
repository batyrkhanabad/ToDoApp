package com.example.ToDoList.service;

import com.example.ToDoList.model.ToDo;
import com.example.ToDoList.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToDoService {
    private ToDoRepository repository;


    @Autowired
    public ToDoService(ToDoRepository repository){
        this.repository = repository;
    }
    public List<ToDo> findAllToDo() {
        return repository.findAll();
    }

    public ToDo saveToDo(ToDo toDo) {
        return repository.save(toDo);
    }

    public ToDo upDate(ToDo toDo) {
        return repository.save(toDo);
    }

    public void deleteToDo(Long id) {
       repository.deleteById(id);
    }


}

package com.example.ToDoList.controller;

import com.example.ToDoList.model.ToDo;
import com.example.ToDoList.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class ToDoController {
    private ToDoService service;


    @GetMapping
    public List<ToDo> findAllToDo(){
       return service.findAllToDo();
    }

    @PostMapping("/save_toDo")
    public String saveToDo(@RequestBody ToDo toDo){
        service.saveToDo(toDo);
        return "Запрос успешно выполнен";
    }

    @PutMapping("/update_toDo")
    public ToDo upDate(@RequestBody ToDo toDo){
         return service.upDate(toDo);
    }

    @DeleteMapping("/delete_toDo/{id}")
    public void deleteToDo(@PathVariable Long id){
        service.deleteToDo(id);
    }
}

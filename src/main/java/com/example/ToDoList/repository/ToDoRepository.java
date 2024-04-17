package com.example.ToDoList.repository;

import com.example.ToDoList.model.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {

}

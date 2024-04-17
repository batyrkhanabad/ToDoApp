package com.example.ToDoList.repository;

import com.example.ToDoList.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

package com.example.ToDoList.controller;

import com.example.ToDoList.model.dto.UserRequestDto;
import com.example.ToDoList.model.dto.UserResponseDto;
import com.example.ToDoList.model.dto.UserUpdatePasswordRequestDto;
import com.example.ToDoList.model.entity.User;
import com.example.ToDoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto request) {
        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public void resetPasswordUser(@PathVariable Long id, @RequestBody UserUpdatePasswordRequestDto userDetails) {
        userService.resetPassword(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
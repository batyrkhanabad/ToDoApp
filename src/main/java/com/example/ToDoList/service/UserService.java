package com.example.ToDoList.service;

import com.example.ToDoList.mapper.UserMapper;
import com.example.ToDoList.model.dto.UserRequestDto;
import com.example.ToDoList.model.dto.UserResponseDto;
import com.example.ToDoList.model.dto.UserUpdatePasswordRequestDto;
import com.example.ToDoList.model.entity.User;
import com.example.ToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserResponseDto createUser(UserRequestDto request) {
        User entity = userMapper.toEntity(request);
        User savedEntity = userRepository.save(entity);
        return userMapper.toDto(savedEntity);
    }

    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void resetPassword(Long id, UserUpdatePasswordRequestDto userDetails) {
        User currentUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        if (!currentUser.getPassword().equals(userDetails.getCurrentPassword())) {
            throw new RuntimeException("User password is not correct!");
        }
        currentUser.setPassword(userDetails.getNewPassword());
        userRepository.save(currentUser);
    }

    public void deleteUser(Long id) {
        User currentUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        currentUser.setIsDeleted(true);
        userRepository.save(currentUser);
    }
}
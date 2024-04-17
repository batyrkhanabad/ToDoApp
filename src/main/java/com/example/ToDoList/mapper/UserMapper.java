package com.example.ToDoList.mapper;

import com.example.ToDoList.model.dto.UserRequestDto;
import com.example.ToDoList.model.dto.UserResponseDto;
import com.example.ToDoList.model.entity.User;

public interface UserMapper {
    User toEntity(UserRequestDto requestDto);

    UserResponseDto toDto(User user);
}

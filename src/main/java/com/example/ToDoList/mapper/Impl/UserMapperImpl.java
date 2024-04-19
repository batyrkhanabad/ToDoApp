package com.example.ToDoList.mapper.Impl;

import com.example.ToDoList.mapper.UserMapper;
import com.example.ToDoList.model.dto.UserRequestDto;
import com.example.ToDoList.model.dto.UserResponseDto;
import com.example.ToDoList.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toEntity(UserRequestDto requestDto) {
        User u = new User();
        u.setPassword(requestDto.getPassword());
        u.setUsername(requestDto.getUsername());
        u.setId(requestDto.getId());
        return u;
    }

    @Override
    public UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .username(user.getUsername())
                .build();
    }
}

package com.example.ToDoList.mapper;

import com.example.ToDoList.model.dto.ToDoRequestDto;
import com.example.ToDoList.model.dto.ToDoResponseDto;
import com.example.ToDoList.model.entity.ToDo;
import com.example.ToDoList.model.entity.User;

public interface ToDoMapper {
    ToDo toEntity(ToDoRequestDto toDoRequestDto, User user);

    ToDoResponseDto todoDto(ToDo toDo);
}

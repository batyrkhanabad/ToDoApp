package com.example.ToDoList.mapper.Impl;

import com.example.ToDoList.mapper.ToDoMapper;
import com.example.ToDoList.model.dto.ToDoRequestDto;
import com.example.ToDoList.model.dto.ToDoResponseDto;
import com.example.ToDoList.model.entity.ToDo;
import com.example.ToDoList.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TodoMapperImpl implements ToDoMapper {
    @Override
    public ToDo toEntity(ToDoRequestDto toDoRequestDto, User user) {
        ToDo toDo = new ToDo();
        toDo.setId(toDoRequestDto.getId());
        toDo.setTitle(toDoRequestDto.getTitle());
        toDo.setDescription(toDoRequestDto.getDescription());
        toDo.setDate(toDoRequestDto.getDate());
        toDo.setStatus(toDoRequestDto.isStatus());
        toDo.setCustomUser(user);
        return toDo;
    }

    @Override
    public ToDoResponseDto todoDto(ToDo toDo) {
        return ToDoResponseDto.builder()
                .title(toDo.getTitle())
                .id(toDo.getId())
                .date(toDo.getDate())
                .username(toDo.getCustomUser().getUsername())
                .build();
    }
}

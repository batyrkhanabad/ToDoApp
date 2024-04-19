package com.example.ToDoList.service;

import com.example.ToDoList.mapper.ToDoMapper;
import com.example.ToDoList.model.dto.ToDoRequestDto;
import com.example.ToDoList.model.dto.ToDoResponseDto;
import com.example.ToDoList.model.entity.ToDo;
import com.example.ToDoList.model.entity.User;
import com.example.ToDoList.repository.ToDoRepository;
import com.example.ToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;
    private final ToDoMapper toDoMapper;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository, UserRepository userRepository, ToDoMapper toDoMapper) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
        this.toDoMapper = toDoMapper;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDoResponseDto createToDo(ToDoRequestDto toDoRequestDto) {
        Optional<User> user = userRepository.findByUsername(toDoRequestDto.getUsername());

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found! Username = " + toDoRequestDto.getUsername());
        }

        ToDo toDoEntity = toDoMapper.toEntity(toDoRequestDto, user.get());

        ToDo savedEntity = toDoRepository.save(toDoEntity);
        return toDoMapper.todoDto(savedEntity);
    }

    public ToDoResponseDto upDateToDo(Long id, ToDoRequestDto requestDetail) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));

        toDo.setTitle(requestDetail.getTitle());
        toDo.setDescription(requestDetail.getDescription());
        toDo.setDate(requestDetail.getDate());
        toDo.setStatus(requestDetail.isStatus());

        ToDo savedToDo = toDoRepository.save(toDo);

        ToDoResponseDto responseDto = new ToDoResponseDto();
        responseDto.setTitle(savedToDo.getTitle());
        responseDto.setDescription(savedToDo.getDescription());
        responseDto.setDate(savedToDo.getDate());
        responseDto.setStatus(savedToDo.isStatus());

        return responseDto;
    }

    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }
}
package com.example.ToDoList.model.dto;

import com.example.ToDoList.model.entity.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ToDoRequestDto {
    private Long id;
    private String  title;
    private String description;
    private LocalDate date;
    private boolean status;
    private String username;
}

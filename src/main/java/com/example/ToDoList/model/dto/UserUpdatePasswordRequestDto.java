package com.example.ToDoList.model.dto;

import lombok.Data;

@Data
public class UserUpdatePasswordRequestDto {
    private String currentPassword;
    private String newPassword;
}

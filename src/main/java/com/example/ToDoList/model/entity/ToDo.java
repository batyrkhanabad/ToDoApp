package com.example.ToDoList.model.entity;

import com.example.ToDoList.model.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "to_do")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  title;
    private String description;
    private LocalDate date;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package com.example.ToDoList.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String  title;
    private String description;
    @Column(nullable = false)
    private LocalDate date;
    private String status;
}

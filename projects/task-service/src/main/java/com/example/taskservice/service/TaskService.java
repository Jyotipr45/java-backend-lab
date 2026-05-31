package com.example.taskservice.service;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.example.taskservice.api.v1.dto.UpdateTaskRequestDto;
import com.example.taskservice.entity.Task;

import java.util.List;

public interface TaskService {
    // Create Task
    Task createTask(CreateTaskRequestDto requestDto);
    // Get all Tasks
    List<Task> getAllTasks();
    // Get Task by ID
    Task getTaskById(Long id);
    // Update Task by ID
    Task updateTask(Long id, UpdateTaskRequestDto requestDto);
    // Delete Task by ID
    void deleteTask(Long id);
}

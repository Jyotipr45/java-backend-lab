package com.jash.taskservice.service;

import com.jash.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.jash.taskservice.api.v1.dto.PageResponseDto;
import com.jash.taskservice.api.v1.dto.TaskResponseDto;
import com.jash.taskservice.api.v1.dto.UpdateTaskRequestDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {
    // Create Task
    TaskResponseDto createTask(CreateTaskRequestDto requestDto);
    // Get all Tasks
    PageResponseDto<TaskResponseDto> getAllTasks(int page, int size);
    // Get Task by ID
    TaskResponseDto getTaskById(Long id);
    // Update Task by ID
    TaskResponseDto updateTask(Long id, UpdateTaskRequestDto requestDto);
    // Delete Task by ID
    void deleteTask(Long id);
}

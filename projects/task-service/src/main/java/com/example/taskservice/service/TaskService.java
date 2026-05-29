package com.example.taskservice.service;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.example.taskservice.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequestDto requestDto);
}

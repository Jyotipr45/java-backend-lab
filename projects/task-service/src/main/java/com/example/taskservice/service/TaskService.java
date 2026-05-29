package com.example.taskservice.service;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;

public interface TaskService {
    public CreateTaskRequestDto createTask(CreateTaskRequestDto requestDto);
}

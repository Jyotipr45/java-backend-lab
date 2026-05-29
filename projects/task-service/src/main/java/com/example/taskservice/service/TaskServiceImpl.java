package com.example.taskservice.service;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{
    @Override
    public CreateTaskRequestDto createTask(CreateTaskRequestDto requestDto){
        return requestDto;
    }
}
package com.example.taskservice.api.v1.controller;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.example.taskservice.api.v1.response.ApiResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @GetMapping("/health")
    public ApiResponse<String> health(){
       return new ApiResponse<>(
               true,
               "Task Service Running.",
               null
       );
    }

    @PostMapping("/createTask")
    public ApiResponse<CreateTaskRequestDto> createTask(@Valid @RequestBody CreateTaskRequestDto requestDto){
        return new ApiResponse<>(
                true,
                "Task created Successfully.",
                requestDto
        );
    }
}

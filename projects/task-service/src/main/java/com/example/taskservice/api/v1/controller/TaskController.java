package com.example.taskservice.api.v1.controller;

import com.example.taskservice.api.v1.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

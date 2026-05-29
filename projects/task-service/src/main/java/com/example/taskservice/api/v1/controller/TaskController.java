package com.example.taskservice.api.v1.controller;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.example.taskservice.api.v1.response.ApiResponse;

import com.example.taskservice.entity.Task;
import com.example.taskservice.service.TaskService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/health")
    public ApiResponse<String> health(){
       return new ApiResponse<>(
               true,
               "Task Service Running.",
               null
       );
    }

    @PostMapping("/createTask")
    public ApiResponse<Task> createTask(@Valid @RequestBody CreateTaskRequestDto requestDto){

        Task createdTask = taskService.createTask(requestDto);
        return new ApiResponse<>(
                true,
                "Task created Successfully.",
                createdTask
        );
    }

    @GetMapping("/all")
    public ApiResponse<List<Task>> getAllTask(){
        List<Task> tasks =  taskService.getAllTasks();

        return new ApiResponse<>(
                true,
                "Task fetched Successfully.",
                tasks
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Task> getTaskById(@PathVariable Long id){
        Task task = taskService.getTaskById(id);

        return new ApiResponse<>(
                true,
                "Task fetched successfully.",
                task
        );
    }
}

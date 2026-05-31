package com.example.taskservice.api.v1.controller;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.example.taskservice.api.v1.dto.TaskResponseDto;
import com.example.taskservice.api.v1.dto.UpdateTaskRequestDto;
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
    public ApiResponse<TaskResponseDto> createTask(@Valid @RequestBody CreateTaskRequestDto requestDto){

        TaskResponseDto createdTask = taskService.createTask(requestDto);
        return new ApiResponse<>(
                true,
                "Task created Successfully.",
                createdTask
        );
    }

    @GetMapping("/all")
    public ApiResponse<List<TaskResponseDto>> getAllTask(){
        List<TaskResponseDto> tasks =  taskService.getAllTasks();

        return new ApiResponse<>(
                true,
                "Task fetched Successfully.",
                tasks
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponseDto> getTaskById(@PathVariable Long id){
        TaskResponseDto task = taskService.getTaskById(id);

        return new ApiResponse<>(
                true,
                "Task fetched successfully.",
                task
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponseDto> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskRequestDto requestDto
            ){
        TaskResponseDto updatedTask = taskService.updateTask(id, requestDto);

        return new ApiResponse<>(
                true,
                "Task updated successfully.",
                updatedTask
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
         return new ApiResponse<>(
                 true,
                 "Task deleted successfully.",
                 null
         );
    }

}

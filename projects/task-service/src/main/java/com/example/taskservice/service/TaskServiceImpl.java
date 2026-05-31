package com.example.taskservice.service;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.example.taskservice.api.v1.dto.TaskResponseDto;
import com.example.taskservice.api.v1.dto.UpdateTaskRequestDto;
import com.example.taskservice.common.mapper.TaskMapper;
import com.example.taskservice.entity.Task;
import com.example.taskservice.exception.ResourceNotFoundException;
import com.example.taskservice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponseDto createTask(CreateTaskRequestDto requestDto){
        Task task = new Task(
                requestDto.getTitle()
        );

        Task savedTask = taskRepository.save(task);

        return TaskMapper.toResponseDto(savedTask);
    }

    @Override
    public List<TaskResponseDto> getAllTasks(){
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponseDto)
                .toList();
    }

    @Override
    public TaskResponseDto getTaskById(Long id){
        Task task =  taskRepository.findById(id)
                .orElseThrow(() ->
                            new ResourceNotFoundException("Task not found with id: " + id)
                        );

        return TaskMapper.toResponseDto(task);
    }

    @Override
    public TaskResponseDto updateTask(Long id, UpdateTaskRequestDto requestDto) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id));

        existingTask.setTitle(requestDto.getTitle());

        Task updatedTask = taskRepository.save(existingTask);
        return TaskMapper.toResponseDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id));

        taskRepository.delete(existingTask);
    }
}
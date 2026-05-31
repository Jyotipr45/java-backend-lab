package com.example.taskservice.service;

import com.example.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.example.taskservice.api.v1.dto.UpdateTaskRequestDto;
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
    public Task createTask(CreateTaskRequestDto requestDto){
        Task task = new Task(requestDto.getTitle());
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() ->
                            new ResourceNotFoundException("Task not found with id: " + id)
                        );
    }

    @Override
    public Task updateTask(Long id, UpdateTaskRequestDto requestDto) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id));
        existingTask.setTitle(requestDto.getTitle());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id));

        taskRepository.delete(existingTask);
    }
}
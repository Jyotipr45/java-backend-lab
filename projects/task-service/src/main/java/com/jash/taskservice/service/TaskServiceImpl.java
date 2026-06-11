package com.jash.taskservice.service;

import com.jash.taskservice.api.v1.dto.CreateTaskRequestDto;
import com.jash.taskservice.api.v1.dto.PageResponseDto;
import com.jash.taskservice.api.v1.dto.TaskResponseDto;
import com.jash.taskservice.api.v1.dto.UpdateTaskRequestDto;
import com.jash.taskservice.common.mapper.TaskMapper;
import com.jash.taskservice.entity.Task;
import com.jash.taskservice.exception.ResourceNotFoundException;
import com.jash.taskservice.repository.TaskRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
//    public List<TaskResponseDto> getAllTasks(int page, int size){
//        return taskRepository.findAll()
//                .stream()
//                .map(TaskMapper::toResponseDto)
//                .toList();
//    }
    public PageResponseDto<TaskResponseDto> getAllTasks(int page, int size, String sortBy, String direction){
        Sort.Direction sortDirection =
                direction.equalsIgnoreCase("asc")
                        ? Sort.Direction.ASC
                        : Sort.Direction.DESC;

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by(sortDirection, sortBy)
                );

        Page<TaskResponseDto> taskPage =  taskRepository.findAll(pageable)
                .map(TaskMapper::toResponseDto);

        return new PageResponseDto<>(
                taskPage.getContent(),
                taskPage.getTotalElements(),
                taskPage.getTotalPages(),
                taskPage.getNumber(),
                taskPage.getSize(),
                taskPage.isLast()
        );
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
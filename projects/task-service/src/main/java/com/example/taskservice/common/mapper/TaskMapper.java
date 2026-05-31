package com.example.taskservice.common.mapper;

import com.example.taskservice.api.v1.dto.TaskResponseDto;
import com.example.taskservice.entity.Task;

public class TaskMapper {

    private TaskMapper(){ };
    
    public static TaskResponseDto toResponseDto(Task task){
        return new TaskResponseDto(
                task.getId(),
                task.getTitle()
        );
    }
}

package com.jash.taskservice.common.mapper;

import com.jash.taskservice.api.v1.dto.TaskResponseDto;
import com.jash.taskservice.entity.Task;

public class TaskMapper {

    private TaskMapper(){ };

    public static TaskResponseDto toResponseDto(Task task){
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}

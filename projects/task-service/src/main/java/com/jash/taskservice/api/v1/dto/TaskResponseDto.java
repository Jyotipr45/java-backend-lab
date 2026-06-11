package com.jash.taskservice.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {

    public Long id;
    public String title;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}

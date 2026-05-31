package com.jash.taskservice.api.v1.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskRequestDto {
    @NotBlank(message = "Title must not be blank.")
    public String title;
}

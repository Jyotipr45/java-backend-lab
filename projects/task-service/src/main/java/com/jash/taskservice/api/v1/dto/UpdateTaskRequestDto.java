package com.jash.taskservice.api.v1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UpdateTaskRequestDto {

    @NotBlank(message = "Title must not be blank.")
    public String title;

    public UpdateTaskRequestDto(String title){
        this.title = title;
    }
}

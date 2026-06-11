package com.jash.taskservice.api.v1.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse<T> {
    public boolean success;
    public String message;
    public T results;
    public LocalDateTime timestamp;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(boolean success, String message, T results){
        this.success = success;
        this.message = message;
        this.results = results;
        this.timestamp = LocalDateTime.now();
    }
}

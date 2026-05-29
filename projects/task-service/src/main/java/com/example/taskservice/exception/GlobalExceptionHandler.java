package com.example.taskservice.exception;

import com.example.taskservice.api.v1.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(
            ResourceNotFoundException exception
    ) {

        ApiResponse<String> response =
                new ApiResponse<>(
                        false,
                        exception.getMessage(),
                        null
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationException(MethodArgumentNotValidException exception){
//        Map<String, String> errors = new HashMap<>();
//
//        exception.getBindingResult()
//                .getFieldErrors()
//                .forEach(error -> errors.put(
//                        error.getField(),
//                        error.getDefaultMessage()
//                ));
//
//        ApiResponse<Map<String, String>> response =
//                new ApiResponse<>(
//                        false,
//                        "validation failed.",
//                        errors
//                );
//        return new ResponseEntity<>(
//                response,
//                HttpStatus.BAD_REQUEST
//        );
//    }
}

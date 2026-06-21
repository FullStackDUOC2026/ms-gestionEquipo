package com.example.ms_asignaciones.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AsignacionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(AsignacionNotFoundException ex){
        return ResponseEntity.status(NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity <ErrorResponse> webClientExceptionHandle(WebClientResponseException ex){
        return ResponseEntity.status(ex.getStatusCode()).body( new ErrorResponse(ex.getMessage()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex){
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error inesperado "+ex.getClass().getSimpleName()));
    }


}
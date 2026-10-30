package com.tenant.tenantDemo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(RecordNotFoundException.class)
    public ProblemDetail recordNotFoundExceptionHandler(RecordNotFoundException ex)
    {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        problemDetail.setTitle("Record you are trying to fetch doesnot exists");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setProperty("Error", ex.getMessage());
        return problemDetail;
    }


}

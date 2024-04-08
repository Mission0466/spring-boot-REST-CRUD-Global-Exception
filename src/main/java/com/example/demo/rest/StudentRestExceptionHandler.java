package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // create a custom error obj
        StudentErrorResponse error = new StudentErrorResponse();

        // set the values
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return the response entity. Remember jackson takes cares of sending java pojo to Json
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // what if the user gave string instead of int then client get's 400 error msg due to bad request in ord
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        // create a custom error obj
        StudentErrorResponse error = new StudentErrorResponse();

        // set the values
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        //error.setMessage(exc.getMessage());
        error.setMessage("give the number value");
        error.setTimeStamp(System.currentTimeMillis());

        // return the response entity. Remember jackson takes cares of sending java pojo to Json
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

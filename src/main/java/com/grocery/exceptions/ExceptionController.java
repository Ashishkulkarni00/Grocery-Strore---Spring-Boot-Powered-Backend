package com.grocery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<Object> UserNotFound(UserException exception){
        Error err=new Error(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidGroceryException.class)
    public ResponseEntity<Object> InvalidGrocery(InvalidGroceryException exception){
        Error err=new Error(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidOrderException.class)
    public ResponseEntity<Object> InvalidOrder(InvalidOrderException exception){
        Error err=new Error(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }



}

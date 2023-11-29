package com.grocery.exceptions;

public class InvalidGroceryException extends RuntimeException{

    public InvalidGroceryException(String msg){
        super(msg);
    }
}

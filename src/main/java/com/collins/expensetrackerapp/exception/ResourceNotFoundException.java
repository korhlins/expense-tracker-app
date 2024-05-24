package com.collins.expensetrackerapp.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String massage){
        super(massage);
    };
}


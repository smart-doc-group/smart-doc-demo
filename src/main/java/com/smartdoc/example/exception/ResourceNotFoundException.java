package com.smartdoc.example.exception;

/**
 * @author yu 2020/12/27.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {

    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}

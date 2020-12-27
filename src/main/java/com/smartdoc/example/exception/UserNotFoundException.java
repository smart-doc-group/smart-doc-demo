package com.smartdoc.example.exception;

/**
 * @author yu 2020/12/27.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {

    }
    public UserNotFoundException(String message){
        super(message);
    }
}

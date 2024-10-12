package com.aamir.exception;

public class ExceptionHandler {
    public static RuntimeException throwResourceNotFoundException() {
        return new RuntimeException("Resource not found!");
    }
}

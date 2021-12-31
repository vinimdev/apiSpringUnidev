package com.example.criandoapidozero.exception;

public class ModelNotFoundException extends IllegalArgumentException {

    public ModelNotFoundException(String message) {
        super(message + " not found");
    }
}

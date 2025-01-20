package com.my.dto;

public class ErrorDTO {

    private Class<? extends Exception> exception;
    private String description;

    public ErrorDTO(Class<? extends Exception> exception, String description) {
        this.exception = exception;
        this.description = description;
    }

    public Class<? extends Exception> getException() {
        return exception;
    }

    public String getDescription() {
        return description;
    }
}

package com.lanou.exception;

/**
 * Created by dllo on 17/11/8.
 */
public class CustomerException extends Exception {

    private String message;

    public CustomerException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

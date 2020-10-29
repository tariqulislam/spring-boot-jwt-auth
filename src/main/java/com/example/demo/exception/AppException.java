package com.example.demo.exception;

public class AppException extends Exception {
    private String extraMessage;

    public AppException(String extraMessage) {
        this.extraMessage = extraMessage;
    }

    public AppException(String message, String extraMessage) {
        super(message);
        this.extraMessage = extraMessage;
    }

    public AppException(String message, Throwable cause, String extraMessage) {
        super(message, cause);
        this.extraMessage = extraMessage;
    }

    public AppException(Throwable cause, String extraMessage) {
        super(cause);
        this.extraMessage = extraMessage;
    }

    public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String extraMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.extraMessage = extraMessage;
    }
}

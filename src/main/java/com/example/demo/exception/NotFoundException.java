package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AppException {
    public NotFoundException(String extraMessage) {
        super(extraMessage);
    }

    public NotFoundException(String message, String extraMessage) {
        super(message, extraMessage);
    }

    public NotFoundException(String message, Throwable cause, String extraMessage) {
        super(message, cause, extraMessage);
    }

    public NotFoundException(Throwable cause, String extraMessage) {
        super(cause, extraMessage);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String extraMessage) {
        super(message, cause, enableSuppression, writableStackTrace, extraMessage);
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.NOT_FOUND;
    }
}

package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AppException {
    public BadRequestException(String extraMessage) {
        super(extraMessage);
    }

    public BadRequestException(String message, String extraMessage) {
        super(message, extraMessage);
    }

    public BadRequestException(String message, Throwable cause, String extraMessage) {
        super(message, cause, extraMessage);
    }

    public BadRequestException(Throwable cause, String extraMessage) {
        super(cause, extraMessage);
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String extraMessage) {
        super(message, cause, enableSuppression, writableStackTrace, extraMessage);
    }

    public HttpStatus getServiceStatus() { return HttpStatus.BAD_REQUEST; }
}

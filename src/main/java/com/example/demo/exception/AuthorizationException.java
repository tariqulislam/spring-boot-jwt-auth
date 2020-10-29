package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class AuthorizationException extends AppException {
    public AuthorizationException(String extraMessage) {
        super(extraMessage);
    }

    public AuthorizationException(String message, String extraMessage) {
        super(message, extraMessage);
    }

    public AuthorizationException(String message, Throwable cause, String extraMessage) {
        super(message, cause, extraMessage);
    }

    public AuthorizationException(Throwable cause, String extraMessage) {
        super(cause, extraMessage);
    }

    public AuthorizationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String extraMessage) {
        super(message, cause, enableSuppression, writableStackTrace, extraMessage);
    }


    public HttpStatus getServiceStatus(){
        return HttpStatus.UNAUTHORIZED;
    }
}

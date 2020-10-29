package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class SystemException extends  AppException{
    private boolean needToAlert = true;
    public SystemException(String extraMessage) {
        super(extraMessage);
    }

    public SystemException(String message, String extraMessage) {
        super(message, extraMessage);
    }

    public SystemException(String message, Throwable cause, String extraMessage) {
        super(message, cause, extraMessage);
    }

    public SystemException(Throwable cause, String extraMessage) {
        super(cause, extraMessage);
    }

    public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String extraMessage) {
        super(message, cause, enableSuppression, writableStackTrace, extraMessage);
    }

    public boolean isNeedToAlert() {
        return needToAlert;
    }

    public void setNeedToAlert(boolean needToAlert) {
        this.needToAlert = needToAlert;
    }

    public HttpStatus getServiceStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

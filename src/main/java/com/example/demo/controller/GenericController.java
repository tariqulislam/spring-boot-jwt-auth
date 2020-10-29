package com.example.demo.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.example.demo.utils.AppConstant.*;

@Component
public abstract class GenericController {

    protected ResponseEntity<?> getResponse(Boolean status, HttpStatus httpStatus, String message, Object data) {
        return ResponseEntity.status(httpStatus).body(ImmutableMap.of(STATUS, status,
                STATUS_CODE, httpStatus.value(),
                MESSAGE, message, DATA, data));
    }
}

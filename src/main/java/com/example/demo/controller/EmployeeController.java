package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController extends  GenericController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees() throws BadRequestException {
        return getResponse(true, HttpStatus.OK, "Admin Retrieve Successfully", employeeService.getAllEmployee());
    }
}

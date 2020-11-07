package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminController extends  GenericController{
    @Autowired
    AdminService adminService;

    @GetMapping
    public ResponseEntity<?> getAllAdminInfo() throws BadRequestException {
        return getResponse(true, HttpStatus.OK, "Admin Info Retrieve Successfully", adminService.getAllAdmin() );
    }
}

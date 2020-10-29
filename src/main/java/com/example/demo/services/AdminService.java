package com.example.demo.services;

import com.example.demo.exception.BadRequestException;
import com.example.demo.models.Admin;
import com.example.demo.models.Role;
import com.example.demo.models.RoleName;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public Admin save(Admin admin) throws BadRequestException {
        if(adminRepository.findByUsername(admin.getUsername()).isPresent())
            throw new BadRequestException("This Username already exists");
         Set<Role> newRoles = new HashSet<>();
         newRoles.add(roleRepository.findByName(RoleName.ROLE_ADMIN).get());
        admin.setRole(newRoles);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
}

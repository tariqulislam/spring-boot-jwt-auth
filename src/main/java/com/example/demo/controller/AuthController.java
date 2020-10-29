package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.exception.AuthorizationException;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.models.*;
import com.example.demo.payload.JwtAuthenticationResponse;
import com.example.demo.payload.SignupRequest;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController extends GenericController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthService authService;

    @Autowired
    PasswordEncoder passwordEncoder;



    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody Map<String, Object> user) throws AuthorizationException {
        try {
            Authentication authentication = authenticationManager.authenticate(authService.getAuthenticationToken(user));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, "Login Successfully"));
        } catch (Exception ex) {
            throw new AuthorizationException("authorization.failed");
        }
    }


    public ResponseEntity<?> register(@Valid @RequestBody SignupRequest signupRequest) throws BadRequestException, NotFoundException {
        if (userRepository.existsByUsername(signupRequest.getUsername()))
            throw new BadRequestException("User Already Exists");

        User user = null;

        String userType = signupRequest.getUserType();

        Optional<Role> userRole = Optional.empty();

        if(userType.equals("admin")) {
            user = new Admin();
            userRole = roleRepository.findByName(RoleName.ROLE_ADMIN);
        }

        if(userType.equals("employee")) {
            user = new Employee();
            userRole = roleRepository.findByName(RoleName.ROLE_EMPLOYEE);
        }

        if(!userRole.isPresent())
            throw new NotFoundException("User not found");

        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        user.setRole(Collections.singleton(userRole.get()));

        return getResponse(true, HttpStatus.CREATED, "User Created Successfully", userRepository.save(user));
    }
}

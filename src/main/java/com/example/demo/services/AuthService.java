package com.example.demo.services;

import com.example.demo.exception.BadRequestException;
import com.example.demo.utils.UserConstant;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {
    public UsernamePasswordAuthenticationToken getAuthenticationToken(Map<String, Object> user) throws BadRequestException {
        if(!user.containsKey(UserConstant.USERNAME) || !user.containsKey(UserConstant.PASSWORD))
            throw new BadRequestException("Provide correct key and values");

        String principal = user.get(UserConstant.USERNAME).toString();
        String password = user.get(UserConstant.PASSWORD).toString();

        return new UsernamePasswordAuthenticationToken(principal, password);

    }
}

package com.example.demo.security;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + s));
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id)  throws UsernameNotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new UsernameNotFoundException("User not found" + id)
        );

        return UserPrincipal.create(user);
    }
}

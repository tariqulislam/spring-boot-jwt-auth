package com.example.demo.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

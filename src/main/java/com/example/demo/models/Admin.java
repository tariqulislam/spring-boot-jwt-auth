package com.example.demo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin  extends  User{
    public Admin() {}

    public Admin(String username, String password) {super(username, password);}
}

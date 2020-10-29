package com.example.demo.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("employee")
public class Employee extends User {
  public Employee() {}
  public Employee(String username, String password) {super(username,password);}
}

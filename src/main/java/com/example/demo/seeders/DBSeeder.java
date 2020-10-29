package com.example.demo.seeders;

import com.example.demo.models.*;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.exception.SystemException;

import java.util.HashSet;
import java.util.Set;

@Component
public class DBSeeder {
    private Logger logger =  LoggerFactory.getLogger(DBSeeder.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener
    public void seed(ContextRefreshedEvent event) throws SystemException {
        seedRoleTable();
        seedAdminTable();
        seedEmployeeTable();
    }


    private void seedRoleTable() throws com.example.demo.exception.SystemException{
        long roleCount = roleRepository.count();
        if(roleCount == 0) {
            try {
                Role role = new Role();
                role.setName(RoleName.ROLE_ADMIN);
                roleRepository.save(role);

                role = new Role();
                role.setName(RoleName.ROLE_EMPLOYEE);
                roleRepository.save(role);

                role = new Role();
                role.setName(RoleName.ROLE_SUPER_ADMIN);
                roleRepository.save(role);
            } catch (Exception ex) {
                throw ex;
            }
        }

    }

    public void seedAdminTable() throws  SystemException {
        long adminCount = adminRepository.count();
        if(adminCount == 0) {
            try {
                Set<Role> roles = new HashSet<>();
                roles.add(roleRepository.findByName(RoleName.ROLE_ADMIN).get());

                Admin admin = new Admin("tariqul.islam.rony@gmail.com", passwordEncoder.encode("admin1234"));
                admin.setRole(roles);
                adminRepository.save(admin);

            } catch (Exception ex) {
                throw  ex;
            }
        }
    }

    public void seedEmployeeTable() throws  SystemException {
        long employeeCount = employeeRepository.count();
        if(employeeCount == 0) {
            try {
                Set<Role> roles = new HashSet<>();
                roles.add(roleRepository.findByName(RoleName.ROLE_EMPLOYEE).get());

                Employee employee = new Employee("tariqul@gmail.com", passwordEncoder.encode("admin1234"));
                employee.setRole(roles);
                employeeRepository.save(employee);

            } catch (Exception ex) {
                throw  ex;
            }
        }
    }



}

package com.kode19.eazybankbackend.controller;

import com.kode19.eazybankbackend.security.Customer;
import com.kode19.eazybankbackend.security.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class LoginController {


    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    public LoginController(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

        String encodePassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodePassword);

        try {
            Customer savedCustomer = customerRepository.save(customer);
            return ResponseEntity.created(URI.create("/register")).body("Customer Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

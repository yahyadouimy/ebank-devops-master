package com.ebank.customer_service.web;

import com.ebank.customer_service.entities.Customer;
import com.ebank.customer_service.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

     CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Customer productById(@PathVariable long id){
        return customerRepository.findById(id).get();
    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

}

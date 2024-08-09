package com.acciojob.RideSwift.controller;

import com.acciojob.RideSwift.Enum.Gender;
import com.acciojob.RideSwift.dto.request.CustomerRequest;
import com.acciojob.RideSwift.dto.response.CustomerResponse;
import com.acciojob.RideSwift.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    // constructor injection
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse response = customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // get all customers of a particular gender and above particular age

    @GetMapping("/gender/{gender}/age/{age}")
    public ResponseEntity<List<CustomerResponse>> getCustomerByGenderAndAgeGreaterThan(@PathVariable("gender") Gender gender, @PathVariable("age") int age) {
        List<CustomerResponse> customerResponses = customerService.getCustomerByGenderAndAgeGreaterThan(gender,age);
        return new ResponseEntity<>(customerResponses,HttpStatus.FOUND);
    }
}

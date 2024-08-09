package com.acciojob.RideSwift.service;

import com.acciojob.RideSwift.Enum.Gender;
import com.acciojob.RideSwift.dto.request.CustomerRequest;
import com.acciojob.RideSwift.dto.response.CustomerResponse;
import com.acciojob.RideSwift.model.Customer;
import com.acciojob.RideSwift.repository.CustomerRepository;
import com.acciojob.RideSwift.transformer.CustomerTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        // save the customer
        Customer savedCustomer = customerRepository.save(customer);
        // entity -> response dto
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getCustomerByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getByGenderAndAgeGreaterThan(gender,age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}

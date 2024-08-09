package com.acciojob.RideSwift.transformer;

import com.acciojob.RideSwift.dto.request.CustomerRequest;
import com.acciojob.RideSwift.dto.response.CustomerResponse;
import com.acciojob.RideSwift.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .address(customerRequest.getAddress())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .build();
    }
}

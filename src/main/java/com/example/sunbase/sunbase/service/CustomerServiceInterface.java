package com.example.sunbase.sunbase.service;

import com.example.sunbase.sunbase.dto.CustomerDto;
import com.example.sunbase.sunbase.dto.CustomerResponse;

public interface CustomerServiceInterface {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(CustomerDto customerDto, long id);

    CustomerDto getCustomerById(long id);

    void deleteCustomer(long id);

    CustomerResponse getAllCustomers(int pageNo, int pageSize, String sortBy, String sortDir);

    CustomerDto searchbyPhoneNo(String phoneno);

    CustomerDto searchbyEmailId(String email);

    CustomerDto searchbyCity(String city);

    CustomerDto searchbyFirstName(String firstName);
}

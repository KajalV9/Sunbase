package com.example.sunbase.sunbase.service;

import com.example.sunbase.sunbase.dto.CustomerDto;
import com.example.sunbase.sunbase.dto.CustomerResponse;
import com.example.sunbase.sunbase.exception.entity.Customer;
import com.example.sunbase.sunbase.exception.ResourceNotFoundException;
import com.example.sunbase.sunbase.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerServiceInterface {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;


    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        // convert DTO to entity
        Customer customer = mapToEntity(customerDto);
        Customer newCustomer = customerRepository.save(customer);


        // convert entity to DTO
        CustomerDto customerResponse = mapToDTO(newCustomer);
        return customerResponse;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customer.setAddress(customerDto.getAddress());
        customer.setCity(customerDto.getCity());
        customer.setEmail(customerDto.getEmail());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneno(customerDto.getPhoneno());

        Customer updatedCustomer = customerRepository.save(customer);
        return mapToDTO(updatedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return mapToDTO(customer);
    }

    @Override
    public void deletePost(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerResponse getAllCustomers(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();


        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Customer> posts = customerRepository.findAll(pageable);

        // get content for page object
        List<Customer> listOfPosts = posts.getContent();

        List<CustomerDto> content= listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setContent(content);
        customerResponse.setPageNo(posts.getNumber());
        customerResponse.setPageSize(posts.getSize());
        customerResponse.setTotalElements(posts.getTotalElements());
        customerResponse.setTotalPages(posts.getTotalPages());
        customerResponse.setLast(posts.isLast());

        return customerResponse;
    }

    @Override
    public CustomerDto searchbyPhoneNo(String phoneno) {
        Customer customer = customerRepository.findByphoneno(phoneno);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer", "phoneno", Long.parseLong(phoneno));
        }
        return mapToDTO(customer);
    }


    public CustomerDto searchbyEmailId(String email) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer", "email", customer.getId());
        }
        return mapToDTO(customer);
    }

    public CustomerDto searchbyCity(String city) {
        Customer customer = customerRepository.findByCity(city);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer", "city", customer.getId());
        }
        return mapToDTO(customer);
    }


    public CustomerDto searchbyFirstName(String firstName) {
        Customer customer = customerRepository.findByFirstName(firstName);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer", "firstName", customer.getId());
        }
        return mapToDTO(customer);
    }

    private CustomerDto mapToDTO(Customer customer) {
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }

    // convert DTO to entity
    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return customer;
    }


}

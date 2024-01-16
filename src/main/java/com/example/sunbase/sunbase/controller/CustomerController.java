package com.example.sunbase.sunbase.controller;

import com.example.sunbase.sunbase.dto.CustomerDto;
import com.example.sunbase.sunbase.dto.CustomerResponse;
import com.example.sunbase.sunbase.exception.ResourceNotFoundException;
import com.example.sunbase.sunbase.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.sunbase.sunbase.utils.AppConstants.*;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:63342")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //http://localhost:8080/api/customers
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    //http://localhost:8080/api/customers/1
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customerDto, @PathVariable(name = "id") long id){

        CustomerDto custResponse = customerService.updateCustomer(customerDto, id);

        return new ResponseEntity<>(custResponse, HttpStatus.OK);
    }

    //http://localhost:8080/api/customers/6
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    //http://localhost:8080/api/customers/6
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") long id){

        customerService.deleteCustomer(id);

        return new ResponseEntity<>("Customer deleted successfully.", HttpStatus.OK);
    }


    // get all customers rest api
//    http://localhost:8080/api/customers
    //http://localhost:8080/api/customers?pageNo=0&pageSize=4 : Pagination
    //http://localhost:8080/api/customers?pageNo=0&pageSize=4&sortBy=title&sortDir=desc : Pagination & sorting
    @GetMapping
    public CustomerResponse getAllCustomers(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_BY_DIRECTION, required = false) String sortDir
    ){
        return customerService.getAllCustomers(pageNo, pageSize, sortBy, sortDir);
    }


    //GET http://localhost:8080/api/customers/searchByPhone/1234567890
    @GetMapping("/searchByPhone/{phoneno}")
    public ResponseEntity<CustomerDto> searchByPhoneNo(@PathVariable String phoneno) {
        try {
            CustomerDto customerDto = customerService.searchbyPhoneNo(phoneno);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //GET http://localhost:8080/api/customers/searchByemail/kajalv1028@gmail.com
    @GetMapping("/searchByemail/{email}")
    public ResponseEntity<CustomerDto> searchByEmail(@PathVariable String email) {
        try {
            CustomerDto customerDto = customerService.searchbyEmailId(email);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //GET http://localhost:8080/api/customers/searchBycity/Pune
    @GetMapping("/searchBycity/{city}")
    public ResponseEntity<CustomerDto> searchByCity(@PathVariable String city) {
        try {
            CustomerDto customerDto = customerService.searchbyCity(city);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //GET http://localhost:8080/api/customers/searchByfirstname/Kajal
    @GetMapping("/searchByfirstname/{firstName}")
    public ResponseEntity<CustomerDto> searchByFirstname(@PathVariable String firstName) {
        try {
            CustomerDto customerDto = customerService.searchbyFirstName(firstName);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

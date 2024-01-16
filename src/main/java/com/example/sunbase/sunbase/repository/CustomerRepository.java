package com.example.sunbase.sunbase.repository;

import com.example.sunbase.sunbase.exception.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByphoneno(String phoneno);

    Customer findByEmail(String email);

    Customer findByCity(String city);

    Customer findByFirstName(String firstName);
}

package com.example.sunbase.sunbase.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    private long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String street;

    @NotEmpty
    private String address;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 9, message = "Phone number must be between 10 characters")
    private String phoneno;
}

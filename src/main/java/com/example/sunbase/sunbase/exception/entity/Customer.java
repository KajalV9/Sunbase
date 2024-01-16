package com.example.sunbase.sunbase.exception.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "customers",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "phoneno"})}
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String street;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String email;

    @Column
    private String phoneno;

}
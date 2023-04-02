package com.training.nagarro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.nagarro.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}

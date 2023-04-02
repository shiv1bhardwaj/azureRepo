package com.training.nagarro.services;

import java.util.List;

import com.training.nagarro.entities.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomer(String customerId);
	
	Customer deleteCustomer(String customerId);
	
	Customer updateCustomer(Customer customer);
}

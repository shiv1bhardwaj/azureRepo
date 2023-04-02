package com.training.nagarro.services.implementation;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.nagarro.entities.Customer;
import com.training.nagarro.exceptions.ResourceNotFoundException;

import com.training.nagarro.repositories.CustomerRepository;
import com.training.nagarro.services.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer saveCustomer(Customer customer) {
		String randomCustomerId=UUID.randomUUID().toString();
		customer.setCustomerId(randomCustomerId);
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		 List<Customer> customerList=customerRepository.findAll();
		 return customerList;
	}

	@Override
	public Customer getCustomer(String customerId) {
		Customer customer=customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer with given id is not found on server "+customerId));

		
		return customer;
	}

	@Override
	public Customer deleteCustomer(String customerId) {
		Customer deletedCustomer=customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer with given id "+customerId+" is not found on server and hence can't be deleted "));
		customerRepository.deleteById(customerId);
		return deletedCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer=customerRepository.save(customer);
		return updatedCustomer;
	}

}

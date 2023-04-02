package com.training.nagarro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.nagarro.entities.Customer;
import com.training.nagarro.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class Controller {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		Customer newCustomer=customerService.saveCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> fetchAllCustomers()
	{
		List<Customer> customersList=customerService.getAllCustomers();
		return ResponseEntity.ok(customersList);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> fetchCustomer(@PathVariable String customerId)
	{
		Customer customer=customerService.getCustomer(customerId);
		return ResponseEntity.ok(customer);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer)
	{
		Customer updatedCustomer= customerService.getCustomer(customerId);
		updatedCustomer.setName(customer.getName());
		updatedCustomer.setAddress(customer.getAddress());
		updatedCustomer.setPhoneno(customer.getPhoneno());
		customerService.updateCustomer(updatedCustomer);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedCustomer);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable String customerId)
	{
		Customer customer=customerService.deleteCustomer(customerId);
		return ResponseEntity.ok(customer);
	}
	

	
}

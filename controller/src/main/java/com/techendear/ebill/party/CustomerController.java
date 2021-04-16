package com.techendear.ebill.party;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techendear.ebill.exceptions.CustomerNotFoundException;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) throws CustomerNotFoundException, Exception {
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("api-path", "/api/v1/user/")
				.body(this.customerService.getCustomerById(id).orElseThrow(() -> new CustomerNotFoundException(id)));
	}

	@GetMapping
	public ResponseEntity<?> getAllCustomers() throws CustomerNotFoundException, Exception {
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("api-path", "/api/v1/user/")
				.body(this.customerService.getAllCustomer().orElseThrow(() -> new CustomerNotFoundException()));
	}
	
	@PostMapping
	public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws CustomerNotFoundException, Exception {

		return ResponseEntity.status(HttpStatus.ACCEPTED).header("api-path", "/api/v1/user/")
				.body(this.customerService.saveCustomer(customer).orElseThrow(() -> new CustomerNotFoundException()));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer)
			throws CustomerNotFoundException, Exception {

		return ResponseEntity.status(HttpStatus.ACCEPTED).header("api-path", "/api/v1/user/" + customer.getCustomerId())
				.body(this.customerService.updateCustomer(id, customer)
						.orElseThrow(() -> new CustomerNotFoundException(id)));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> patchCustomer(@PathVariable("id") Long id, @RequestBody Map<Object, Object> fields)
			throws CustomerNotFoundException, Exception {

		return ResponseEntity.status(HttpStatus.OK).header("api-path", "/api/v1/user/" + id).body(
				this.customerService.patchCustomer(id, fields).orElseThrow(() -> new CustomerNotFoundException(id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) throws CustomerNotFoundException, Exception {

		return ResponseEntity.status(HttpStatus.NO_CONTENT).header("api-path", "/api/v1/user/" + id)
				.body(this.customerService.deleteCustomerById(id).orElseThrow(() -> new CustomerNotFoundException(id)));

	}
}

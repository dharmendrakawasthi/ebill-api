package com.techendear.ebill.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getUserById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().header("api-path", "/api/v1/user/" + id).body(this.customerService.getUserById(id));
	}

	@PostMapping("")
	public ResponseEntity<?> saveUser(@RequestBody Customer customer) {
		return ResponseEntity.ok().header("api-path", "/api/v1/user/").body(this.customerService.saveUser(customer));
	}

	@PutMapping("")
	public ResponseEntity<?> updateUser(@RequestBody Customer customer) {
		try {
			return ResponseEntity.ok().header("api-path", "/api/v1/user/" + customer.getUserId())
					.body(this.customerService.updateUser(customer));
		} catch (Exception e) {
			return ResponseEntity.ok("ERROR: " + e.getMessage());
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> patchUser(@PathVariable("id") Long id, @RequestBody Map<Object, Object> fields) {

		try {
			return ResponseEntity.ok().header("api-path", "/api/v1/user/" + id)
					.body(this.customerService.patchUser(id, fields));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

package com.techendear.ebill.party;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techendear.ebill.party.Customer;
import com.techendear.ebill.party.MapToEntity;
import com.techendear.ebill.user.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	MapToEntity<Customer> updatedUser;
	
	@Override
	public Customer getUserById(Long id) {
		return this.customerRepository.findById(id).get();
	}

	@Override
	public List<Customer> getAllUsers() {
		return this.customerRepository.findAll();
	}

	@Override
	public Customer saveUser(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer updateUser(Customer customer) throws Exception {
		Customer existingUser = this.customerRepository.findById(customer.getUserId()).get();
		if (existingUser.getUserId() != customer.getUserId()) {
			throw new Exception("Customer doesn't exists with id: " + existingUser.getUserId());
		}
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer patchUser(Long id, Map<Object, Object> fields) throws Exception {
		Customer customer = this.customerRepository.findById(id).get();
		this.updatedUser.mapToEntity(fields, customer);
		return this.customerRepository.save(customer);
	}
}

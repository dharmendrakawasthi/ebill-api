package com.techendear.ebill.party;

import java.util.List;
import java.util.Map;

import com.techendear.ebill.party.Customer;

public interface CustomerService {

	public Customer getUserById(Long id);

	public List<Customer> getAllUsers();

	public Customer saveUser(Customer customer);

	public Customer updateUser(Customer customer) throws Exception;

	public Customer patchUser(Long id, Map<Object, Object> fields) throws Exception;
	
}

package com.techendear.ebill.party;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface CustomerService {

	public Optional<Customer> getCustomerById(Long id) throws Exception;;

	public Optional<Page<Customer>> getAllCustomer() throws Exception;

	public Optional<Customer> saveCustomer(Customer customer) throws Exception;

	public Optional<Customer> updateCustomer(Long id, Customer customer) throws Exception;

	public Optional<Customer> patchCustomer(Long id, Map<Object, Object> fields) throws Exception;

	public Optional<Long> deleteCustomerById(Long id) throws Exception;
}

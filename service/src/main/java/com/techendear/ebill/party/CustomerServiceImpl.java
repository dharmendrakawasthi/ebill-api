package com.techendear.ebill.party;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techendear.ebill.user.CustomerRepository;
import com.techendear.ebill.util.MapToEntity;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	MapToEntity<Customer> updatedcustomer;

	@Override
	public Optional<Customer> getCustomerById(Long id) throws Exception {
		return this.customerRepository.findById(id);
	}

	@Override
	public Optional<Page<Customer>> getAllCustomer() throws Exception {
		return Optional.of(this.customerRepository.findAll(PageRequest.of(1, 10)));
	}

	@Override
	public Optional<Customer> saveCustomer(Customer customer) throws Exception {
		return Optional.of(this.customerRepository.save(customer));
	}

	@Override
	public Optional<Customer> updateCustomer(Long id, Customer customer) throws Exception {
		return this.customerRepository.findById(id).map(cust -> {
			cust.setFirstName(customer.getFirstName());
			cust.setMiddleName(customer.getMiddleName());
			cust.setLastName(customer.getLastName());
			cust.setType(customer.getType());
			cust.setStatus(customer.getStatus());
			cust.setLastUpdateSummary(customer.getLastUpdateSummary());
//			cust.setContacts(customer.getContacts());
			return this.customerRepository.save(cust);
		});
	}

	@Override
	public Optional<Customer> patchCustomer(Long id, Map<Object, Object> fields) throws Exception {
		return this.customerRepository.findById(id).map(cust -> {
			this.updatedcustomer.mapToEntity(fields, cust);
			return this.customerRepository.save(cust);
		});
	}

	@Override
	public Optional<Long> deleteCustomerById(Long id) throws Exception {
		this.customerRepository.deleteById(id);
		return Optional.of(id);
	}
}

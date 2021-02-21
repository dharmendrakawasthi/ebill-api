package com.techendear.ebill.party;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ContactService {

	public Optional<Customer> getContactById(Long id) throws Exception;;

	public Optional<List<Customer>> getAllContacts() throws Exception;

	public Optional<Customer> saveContact(Customer customer) throws Exception;

	public Optional<Customer> updateContact(Long id, Customer customer) throws Exception;

	public Optional<Customer> patchContact(Long id, Map<Object, Object> fields) throws Exception;

	public Optional<Long> deleteContactById(Long id) throws Exception;
}

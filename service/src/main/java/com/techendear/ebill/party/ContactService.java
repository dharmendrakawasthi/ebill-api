package com.techendear.ebill.party;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface ContactService {

	public Optional<Contact> getContactById(Long id) throws Exception;;

	public Optional<Page<Contact>> getAllContacts() throws Exception;

	public Optional<Contact> saveContact(Customer customer) throws Exception;

	public Optional<Contact> updateContact(Long id, Customer customer) throws Exception;

	public Optional<Contact> patchContact(Long id, Map<Object, Object> fields) throws Exception;

	public Optional<Long> deleteContactById(Long id) throws Exception;
}

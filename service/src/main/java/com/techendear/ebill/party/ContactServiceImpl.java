package com.techendear.ebill.party;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public Optional<Contact> getContactById(Long id) throws Exception {
		return this.contactRepository.findById(id);
	}

	@Override
	public Optional<Page<Contact>> getAllContacts() throws Exception {
		return Optional.of(this.contactRepository.findAll(PageRequest.of(0, 10)));
	}

	@Override
	public Optional<Contact> saveContact(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Contact> updateContact(Long id, Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Contact> patchContact(Long id, Map<Object, Object> fields) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Long> deleteContactById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

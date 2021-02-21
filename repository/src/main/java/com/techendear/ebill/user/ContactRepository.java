package com.techendear.ebill.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techendear.ebill.party.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}

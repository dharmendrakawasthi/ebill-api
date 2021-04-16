package com.techendear.ebill.party;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techendear.ebill.party.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
//	public Page<Customer> findAll(Pageable pageable);
}

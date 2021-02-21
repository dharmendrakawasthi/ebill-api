package com.techendear.ebill.party;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

	@GetMapping("/{id}")
	public ResponseEntity<Set<Contact>> getAddress(@PathVariable("id") Long id){
		return null;
	} 
}

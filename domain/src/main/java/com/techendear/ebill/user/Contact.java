package com.techendear.ebill.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

	@Id
	@SequenceGenerator(name = "contact_id", sequenceName = "contact_id", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id")
	@Column(name = "contact_id", nullable = false)
	private Long contactId;
	private String type;
	private String emails;
	private String phones;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String state;
	private String country;
	private String zipCode;

}

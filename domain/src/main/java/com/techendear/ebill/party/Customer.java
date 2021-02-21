package com.techendear.ebill.party;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@SequenceGenerator(name = "user_id", sequenceName = "user_id", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
	@Column(name = "user_id", nullable = false)
	private Long userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String type;
	private Timestamp createdDate;
	private Timestamp lastUpdated;
	private Boolean status;
	private String lastUpdateSummary;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<Contact> contacts= new HashSet<>();
}

package com.techendear.ebill.party;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners({ AuditingEntityListener.class })
public class Customer {

	@Id
	@SequenceGenerator(name = "user_id", sequenceName = "user_id", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
	@Column(name = "user_id", nullable = false)
	private Long customerId;

	@Column(name = "created_date", nullable = false, updatable = false)
	@CreatedDate
	private Timestamp createdDate;

	@Column(name = "modified_date")
	@LastModifiedDate
	private Timestamp modifiedDate;

	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;

	@Column(name = "modified_by")
	@LastModifiedBy
	private String modifiedBy;

	@Column(nullable = false)
	private String firstName;
	private String middleName;
	private String lastName;

//	@Column(nullable = false)
	private String type;
	private Boolean status;
	private String lastUpdateSummary;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Set<Contact> contacts = new HashSet<>();
}

package com.alesaudate.samples.camel.drools.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InsuranceRequest implements Serializable{

	
	private static final long serialVersionUID = 2688169029370276835L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	
	@OneToOne(cascade=CascadeType.ALL)
	private Person applicant;
	
	@OneToOne(cascade=CascadeType.ALL)
	private InsuranceStatus status;

	public Person getApplicant() {
		return applicant;
	}

	public void setApplicant(Person applicant) {
		this.applicant = applicant;
	}

	public InsuranceStatus getStatus() {
		return status;
	}

	public void setStatus(InsuranceStatus status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}

package com.alesaudate.samples.camel.drools.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InsuranceRequests {
	
	
	@XmlElement(name="insuranceRequest")
	private List<InsuranceRequest> insuranceRequests;
	
	
	public InsuranceRequests(List<InsuranceRequest> insuranceRequests) {
		this.insuranceRequests = insuranceRequests;
	}
	
	public InsuranceRequests() {
		
	}
	
	public List<InsuranceRequest> getInsuranceRequests() {
		return insuranceRequests;
	}
	
	public void setInsuranceRequests(List<InsuranceRequest> insuranceRequests) {
		this.insuranceRequests = insuranceRequests;
	}

}

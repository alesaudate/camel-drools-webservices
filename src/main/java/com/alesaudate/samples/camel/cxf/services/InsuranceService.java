package com.alesaudate.samples.camel.cxf.services;

import com.alesaudate.samples.camel.drools.model.InsuranceStatus;
import com.alesaudate.samples.camel.drools.model.Person;

public interface InsuranceService {
	
	
	
	public InsuranceStatus analyze(Person person);

}

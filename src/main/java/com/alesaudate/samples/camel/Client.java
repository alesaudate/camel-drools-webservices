package com.alesaudate.samples.camel;


import org.apache.cxf.frontend.ClientProxyFactoryBean;

import com.alesaudate.samples.camel.cxf.services.InsuranceService;
import com.alesaudate.samples.camel.drools.model.InsuranceStatus;
import com.alesaudate.samples.camel.drools.model.Person;

public class Client {

	private static final String URL = "http://localhost:8080/camel-drools/webservices/insurance";


	private static InsuranceService createService() {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		factory.setServiceClass(InsuranceService.class);
		factory.setAddress(URL);
		return (InsuranceService) factory.create();
	}

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setAge(18);
		person.setName("Alexandre Saudate");
		
		InsuranceStatus status = createService().analyze(person);
		System.out.println(status.getStatus());

	}

}

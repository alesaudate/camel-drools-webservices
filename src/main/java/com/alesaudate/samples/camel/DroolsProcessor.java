package com.alesaudate.samples.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.drools.runtime.StatelessKnowledgeSession;

public class DroolsProcessor implements Processor{
	
	private StatelessKnowledgeSession session;

	public void process(Exchange arg0) throws Exception {
		Object request = arg0.getIn().getBody();
		session.execute(request);
		arg0.getOut().setBody(request);
	}
	
	
	public StatelessKnowledgeSession getSession() {
		return session;
	}
	
	public void setSession(StatelessKnowledgeSession session) {
		this.session = session;
	}

}

package com.alesaudate.samples.camel.cxf.services;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.orm.jpa.JpaTemplate;

import com.alesaudate.samples.camel.drools.model.InsuranceRequest;
import com.alesaudate.samples.camel.drools.model.InsuranceRequests;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;


@Path("/audit")
public class AuditInsuranceService {
	
	
	
	private JpaTemplate jpaTemplate;
	
	@GET	
	@Produces("application/rss+xml")
	public Response listInsuranceRequests(@Context UriInfo uriInfo) throws IOException, FeedException {
		
		@SuppressWarnings("unchecked")
		Collection<InsuranceRequest> insuranceRequests = jpaTemplate.find("select request from InsuranceRequest request");
		
		
		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType("rss_2.0");
		feed.setTitle("Audit requests");
		feed.setDescription("Audit requests");
		feed.setLink(uriInfo.getRequestUri().toASCIIString());
		List<SyndEntry> entries = new ArrayList<SyndEntry>();
		for (InsuranceRequest insuranceRequest : insuranceRequests) {
			SyndEntry entry = new SyndEntryImpl();
			entry.setAuthor(insuranceRequest.getApplicant().toString());
			SyndContent content = new SyndContentImpl();
			content.setValue("Insurance for applicant " + insuranceRequest.getApplicant() + " has been " + insuranceRequest.getStatus());
			entry.setDescription(content);
			entries.add(entry);
		}
		feed.setEntries(entries);
		
		
		SyndFeedOutput feedOutput = new SyndFeedOutput();
		StringWriter stringWriter = new StringWriter();
		feedOutput.output(feed, stringWriter);
		
		
		return Response.ok(stringWriter.getBuffer().toString()).build();		
	}
	
	
	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}
	
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}
		
	
	
}

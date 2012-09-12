package au.com.spinninghalf.gae.jaxrs.test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


import au.com.spinninghalf.gae.jaxrs.test.dao.Dao;
import au.com.spinninghalf.gae.jaxrs.test.model.Gig;
import au.com.spinninghalf.gae.jaxrs.test.model.AllGigs;


@Path("/gigs")
public class ServletListAllGigs  {
	
	@GET
	@Produces("application/xml")
	public String listGigs() throws Exception {
		JAXBContext jc = JAXBContext.newInstance(AllGigs.class);
		
		AllGigs gigs = new AllGigs();
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(gigs, writer);
		
		String gigString = writer.toString();
		
		return gigString;
		
		
	}

}


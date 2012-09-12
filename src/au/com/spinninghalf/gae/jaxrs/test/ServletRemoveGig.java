package au.com.spinninghalf.gae.jaxrs.test;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import au.com.spinninghalf.gae.jaxrs.test.dao.Dao;

@Path("/done")
public class ServletRemoveGig {
	private static final long serialVersionUID = 1L;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void clearGig(
			@FormParam("deleteGig") String deletedGig,
						 @Context HttpServletRequest req, 
						 @Context HttpServletResponse resp)
				throws IOException {
		
		if (deletedGig == null) {
			System.out.println("No array assignment");
		}
		
		Dao.INSTANCE.removeGig(Long.parseLong(deletedGig));
		resp.sendRedirect("/");
		
		//print out the deleted gig to stdout
		System.out.println(deletedGig);
		System.out.println(req.getUserPrincipal());
	}
	
}

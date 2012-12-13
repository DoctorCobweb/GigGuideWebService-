package au.com.spinninghalf.gae.jaxrs.test;

import java.io.IOException;



import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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

@Path("/new")
public class ServletCreateGig {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newGig(
			@FormParam("date") String _date,
			@FormParam("show") String _show,
			@FormParam("venue") String _venue,
			@FormParam("description") String _description,
			@FormParam("tixUrl") String _tixUrl,
			@FormParam("price") String _price,
			@Context HttpServletResponse resp,
			@Context HttpServletRequest req) throws IOException
			{
	    
		System.out.println("Creating new gig");
		User user = (User) req.getAttribute("user");
		if (user == null) {
			UserService userService = UserServiceFactory.getUserService();
			user = userService.getCurrentUser();
		}
		String date = checkNull(_date);
		String show = checkNull(_show);
		String venue = checkNull(_venue);
		String description = checkNull(_description);
		String tixUrl = checkNull(_tixUrl);
		String price = checkNull(_price);
		
		Dao.INSTANCE.addGig(user.getUserId(), date, venue, show, description, tixUrl, price);
		
		resp.sendRedirect("/gigApplication.jsp");
	}
	
	private String checkNull(String s) {
		if (s == null) {
			return "";
		}
		return s;
	}
}




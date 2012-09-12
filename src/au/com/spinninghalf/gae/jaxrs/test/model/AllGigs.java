package au.com.spinninghalf.gae.jaxrs.test.model;

import java.util.*;
import javax.xml.bind.annotation.*;

import au.com.spinninghalf.gae.jaxrs.test.dao.Dao;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AllGigs {
	
	private List<Gig> gig;
	
	public AllGigs() {
		gig = Dao.INSTANCE.listGigs();
	}
	
	public List<Gig> getAllGigs() {
		return gig;
	}

}

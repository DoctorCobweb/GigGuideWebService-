package au.com.spinninghalf.gae.jaxrs.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import au.com.spinninghalf.gae.jaxrs.test.model.Gig;

public enum Dao {
	INSTANCE;
	

	public List<Gig> listGigs() {
		EntityManager em = EMFService.get().createEntityManager();
		//read the existing entries
		Query q = em.createQuery("select g from Gig g");
		List<Gig> gigs = q.getResultList();
		return gigs;
	}
	
	public void addGig(String userId, String date, String gig, String description,
			String tixUrl, String  price) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Gig newGig = new Gig(userId, date, gig, description, tixUrl, price);
			em.persist(newGig);
			em.close();
		}
	}
	
	public List<Gig> getGigs(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select g from Gig g where g.author = :userId");
		q.setParameter("userId", userId);
		List<Gig> gigs = q.getResultList();
		return gigs;
	}
	
	public void removeGig(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Gig gig = em.find(Gig.class, id);
			em.remove(gig);
		} finally {
			em.close();
		}
	}
}
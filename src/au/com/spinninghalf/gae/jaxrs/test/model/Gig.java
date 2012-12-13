package au.com.spinninghalf.gae.jaxrs.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"id", "author", "show", "date", "venue", "description", "tixUrl", "price"})
@Entity
public class Gig {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String author;
	private String show;
	private String date;
	private String venue;
	private String description;
	private String tixUrl;
	private String price;
	//boolean finished;
	
	public Gig(String author, String date, String venue, String show, String description,
			String tixUrl, String price) {
		this.author = author;
		this.date = date;
		this.venue = venue;
		this.show = show;
		this.description = description;
		this.tixUrl = tixUrl;
		this.price = price;
		//finished = false;
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlElement
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	@XmlElement
	public String getVenue() {
		return venue;
	}
	
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	@XmlElement
	public String getShow() {
		return show;
	}
	
	public void setShow(String show) {
		this.show = show;
	}
	
	
	@XmlElement
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement
	public String getTixUrl() {
		return tixUrl;
	}
	
	public void setTixUrl(String tixUrl) {
		this.tixUrl = tixUrl;
	}
	
	@XmlElement
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	/*
	@XmlElement
	public boolean getFinished() {
		return finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	} */
	
}

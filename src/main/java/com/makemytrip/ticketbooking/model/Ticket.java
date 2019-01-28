package com.makemytrip.ticketbooking.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TicketBooking")
public class Ticket
{
	@Transient
    public static final String SEQUENCE_NAME = "ticket_sequence";
	@Id
	private long ticketId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private long contact;
	public FlightData flightdata;
	
	public Ticket() {
		super();
	}



	public Ticket(long ticketId, String firstName, String lastName, int age, String gender, long contact,
			FlightData flightdata) {
		super();
		this.ticketId = ticketId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contact = contact;
		this.flightdata = flightdata;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public FlightData getFlightdata() {
		return flightdata;
	}

	public void setFlightdata(FlightData flightdata) {
		this.flightdata = flightdata;
	}

	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	
}

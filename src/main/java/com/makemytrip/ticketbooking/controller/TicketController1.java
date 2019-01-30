package com.makemytrip.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.makemytrip.ticketbooking.model.Ticket;

@RestController
@CrossOrigin("*")
public class TicketController1 
{
	@Autowired
	private MongoTemplate mongoTemplate;

	
	@GetMapping("/ticket")
	public List<Ticket> getAllTickets(){
		
		List<Ticket> tickets=mongoTemplate.findAll(Ticket.class);
		if(tickets==null) {
			// throw new NoUserExistException("No User Exist");
		}
		return tickets;
	}
	@PostMapping("/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable long ticketId) {

		Ticket ticket =mongoTemplate.findById(ticketId, Ticket.class);
		if(ticket==null) {
			// throw new UserNotExistException("User Not Exist");
		}
		return ticket;
	}
	//save the provided user object in user collection and returns same object back
	@PostMapping("/ticket")
	public Ticket saveTicket(@RequestBody Ticket ticket) {
		
		Ticket ticket2=mongoTemplate.findOne(new Query(Criteria.where("firstName").is(ticket.getFirstName())), Ticket.class);
		if(ticket2!=null) {
			// throw new AlreadyUserExistException("Already User Exist");
		}
		 mongoTemplate.save(ticket);
		 
		 return ticket;
		
	}
}

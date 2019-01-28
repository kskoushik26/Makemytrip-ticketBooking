package com.makemytrip.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.makemytrip.ticketbooking.model.Ticket;
import com.makemytrip.ticketbooking.repository.TicketRepository;
import com.makemytrip.ticketbooking.supportclass.SequenceGeneratorService;

@RestController
public class TicketController 
{
	@Autowired
	TicketRepository  ticketRepository;
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
	@RequestMapping(method = RequestMethod.POST, value = "/ticket/book")
	public String bookTicket(@RequestBody Ticket ticket) {
		if(ticket!=null) {
			ticket.setTicketId((sequenceGenerator.generateSequence(Ticket.SEQUENCE_NAME)));
			ticketRepository.save(ticket);
			return "ticket booked sucessfully";
		}
		else 
			return "Unbale to book ticket";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/ticket/get")
	public List<Ticket> TicketsList() {
		return ticketRepository.findAll();
	}
	@RequestMapping(method = RequestMethod.GET, value = "ticket/get/{firstName}")
	public Ticket getTicket(@PathVariable String firstName) {
		List<Ticket> tickets=ticketRepository.findAll();
		for (Ticket list1 : tickets ) {

			if (list1.getFirstName().equals(firstName)) {
				return list1;
			}
		}
		return null;
	}

}

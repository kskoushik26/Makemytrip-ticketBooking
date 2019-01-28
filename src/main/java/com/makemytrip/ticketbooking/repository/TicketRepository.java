package com.makemytrip.ticketbooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.makemytrip.ticketbooking.model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, Long> 
{

}

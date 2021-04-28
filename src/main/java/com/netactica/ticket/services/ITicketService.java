package com.netactica.ticket.services;

import java.util.Optional;

import com.netactica.ticket.domain.Ticket;

public interface ITicketService {
	
	Optional<Ticket> buscarTicket(String itineraryID);
	
	String registrarTicket(Ticket ticket);
}

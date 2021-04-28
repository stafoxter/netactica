package com.netactica.ticket.services.impl;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netactica.ticket.domain.Pasajero;
import com.netactica.ticket.domain.Ticket;
import com.netactica.ticket.domain.Vuelo;
import com.netactica.ticket.repositories.IPasajeroRepository;
import com.netactica.ticket.repositories.ITicketRepository;
import com.netactica.ticket.repositories.IVueloRepository;
import com.netactica.ticket.services.ITicketService;
import com.netactica.ticket.services.exception.NegocioException;

@Service
public class TicketServiceImpl implements ITicketService{

	private static final Logger logger = LogManager.getLogger(TicketServiceImpl.class);
	
	@Autowired
	private ITicketRepository ticketRepository;
	
	@Autowired
	private IPasajeroRepository pasajeroRepository;
	
	@Autowired
	private IVueloRepository vueloRepository;
	
	@Override
	public Optional<Ticket> buscarTicket(String itineraryID) {
		logger.info("Ingreso a buscarTicket");
		Optional<Ticket> ticket = ticketRepository.findByItineraryID(itineraryID);
		
		if(!ticket.isPresent())
			throw new NegocioException("No existe ticket con itineraryID "+itineraryID);
		return ticket;
	}

	@Transactional
	@Override
	public String registrarTicket(Ticket ticket) {
		logger.info("Ingreso a registrarTicket");
		String itinerarioID = null;

		if(Objects.nonNull(ticket.getPasajero().getNro())) {
			Optional<Pasajero> pasajero = pasajeroRepository.findByNro(ticket.getPasajero().getNro());
			if(pasajero.isPresent()){
				ticket.setPasajero(pasajero.get());
			}else {
				throw new NegocioException("No existe pasajero nro "+ticket.getPasajero().getNro());
			}	
		}else {
			ticket.getPasajero().setNro(this.generarNroPasajero());
		}
		
		Optional<Vuelo> vuelo = vueloRepository.findByNroVuelo(ticket.getVuelo().getNroVuelo());
		if(vuelo.isPresent()) {
			ticket.setVuelo(vuelo.get());
		}else {
			throw new NegocioException("No existe el vuelo nro "+ticket.getVuelo().getNroVuelo());
		}
		itinerarioID = this.generarItineraryID();
		ticket.setItineraryID(itinerarioID);					
		ticketRepository.save(ticket);

		return itinerarioID;
	}
	
	private String generarItineraryID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	private String generarNroPasajero() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}

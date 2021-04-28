package com.netactica.ticket.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netactica.ticket.domain.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, UUID>{

	Optional<Ticket> findByItineraryID(String itineraryID);

}

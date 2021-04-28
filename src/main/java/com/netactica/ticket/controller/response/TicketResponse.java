package com.netactica.ticket.controller.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

import com.netactica.ticket.domain.Ticket;

import lombok.Data;

@Data
public class TicketResponse {

	private LocalDate fechaSalida;
	private LocalDate fechaLlegada;
	private String ciudadOrigen;
	private String ciudadDestino;
	private String nombrePasajero;
	private int edadPasajero;
	private boolean tieneBodegaEquipaje;
	private double precio;
	private LocalTime horaSalida;
	private LocalTime horaLlegada;
	
	
	public static Optional<TicketResponse> fromDomain(Optional<Ticket> domain) {
	    if(!domain.isPresent())
	        return Optional.empty();
	    
	    TicketResponse response = new TicketResponse();   
	    Ticket ticket = domain.get();
	    response.setPrecio(ticket.getPrecio());
	    if(Objects.nonNull(ticket.getVuelo())){
	    	response.setFechaSalida(ticket.getVuelo().getFechaSalida());
	    	response.setFechaLlegada(ticket.getVuelo().getFechaLlegada());
	    	response.setCiudadOrigen(ticket.getVuelo().getCiudadOrigen().getUbicacionCiudad());
	    	response.setCiudadDestino(ticket.getVuelo().getCiudadDestino().getUbicacionCiudad());
	    	response.setTieneBodegaEquipaje(ticket.getVuelo().isTieneBodegaEquipaje());
	    	response.setHoraSalida(ticket.getVuelo().getHoraSalida());
	    	response.setHoraLlegada(ticket.getVuelo().getHoraLlegada());
	    }
	    if(Objects.nonNull(ticket.getPasajero())){
	    	response.setNombrePasajero(ticket.getPasajero().getNombre());
	    	response.setEdadPasajero(ticket.getPasajero().getEdad());
	    }
		return Optional.of(response);
	}
}

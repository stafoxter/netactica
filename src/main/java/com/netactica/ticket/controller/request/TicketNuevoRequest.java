package com.netactica.ticket.controller.request;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.netactica.ticket.controller.validation.ICustomConstraint;
import com.netactica.ticket.domain.Pasajero;
import com.netactica.ticket.domain.Ticket;
import com.netactica.ticket.domain.Vuelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Request nuevo ticket de vuelo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ICustomConstraint
public class TicketNuevoRequest {
    @ApiModelProperty(notes = "Nombre completo del pasajero")
	private String nombrePasajero;
    @ApiModelProperty(notes = "Edad del pasajero")
	private int edadPasajero;	
	@ApiModelProperty(notes = "Número de pasajero")
	private String nroPasajero;	
    @ApiModelProperty(notes = "Número de vuelo")
    @NotNull(message= "Ingrese el número de vuelo")
	private String nroVuelo;
    @ApiModelProperty(notes = "Precio final del ticket")
    @NotNull(message= "Ingrese precio final del ticket")
	private double precio;
    
	public static Ticket toDomain(TicketNuevoRequest request) {
		
	    if(Objects.isNull(request))
	        return null;
	    
	    Ticket domain = new Ticket();
	    domain.setPrecio(request.getPrecio());
	    
	    Pasajero pasajero = new Pasajero();
	    pasajero.setNro(request.getNroPasajero());
	    pasajero.setNombre(request.getNombrePasajero());
	    pasajero.setEdad(request.getEdadPasajero());
	    domain.setPasajero(pasajero);
	    
	    Vuelo vuelo = new Vuelo();
	    vuelo.setNroVuelo(request.getNroVuelo());
	    domain.setVuelo(vuelo);
	    
		return domain;
	}
}

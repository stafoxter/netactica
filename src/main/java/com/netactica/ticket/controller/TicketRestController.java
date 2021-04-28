package com.netactica.ticket.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netactica.ticket.controller.request.TicketNuevoRequest;
import com.netactica.ticket.controller.response.TicketResponse;
import com.netactica.ticket.services.ITicketService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/tickets")
@RequestMapping("/tickets")
public class TicketRestController {
	
	@Autowired
	private ITicketService ticketService; 
	
	@ApiOperation(value = "Crear ticket")
	@PostMapping(path = "")
	public ResponseEntity<Object> crearTicket(@Valid @RequestBody TicketNuevoRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ticketService.registrarTicket(TicketNuevoRequest.toDomain(request)));
	}
	
	@ApiOperation(value = "Consultar ticket")
	@GetMapping(path = "/{itineraryID}")
	public ResponseEntity<Object> consultarTicket(@NotNull(message= "Ingrese itineraryID") 
												@PathVariable("itineraryID") String itineraryID) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(TicketResponse.fromDomain(ticketService.buscarTicket(itineraryID)).get());
	}
	
}

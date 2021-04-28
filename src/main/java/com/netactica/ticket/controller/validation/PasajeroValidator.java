package com.netactica.ticket.controller.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.netactica.ticket.controller.request.TicketNuevoRequest;

@Component
public class PasajeroValidator implements ConstraintValidator<ICustomConstraint, Object> {

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (!(object instanceof TicketNuevoRequest)) {
            throw new IllegalArgumentException("Error en validación de pasajero");
        }
        
        TicketNuevoRequest ticketRequest = (TicketNuevoRequest) object;
        
        if(Objects.nonNull(ticketRequest.getNroPasajero()) &&
        		(Objects.isNull(ticketRequest.getNombrePasajero()) && 
        				ticketRequest.getEdadPasajero() == 0))
        	return true;

        if(Objects.isNull(ticketRequest.getNroPasajero()) &&
        		(Objects.nonNull(ticketRequest.getNombrePasajero()) && 
        				ticketRequest.getEdadPasajero() > 0))
        	return true;
        
        return false;
	}

}

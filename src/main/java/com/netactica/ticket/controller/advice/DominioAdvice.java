package com.netactica.ticket.controller.advice;

import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.netactica.ticket.controller.response.ErrorResponse;
import com.netactica.ticket.controller.response.ErroresResponse;
import com.netactica.ticket.services.exception.NegocioException;

@ControllerAdvice
public class DominioAdvice {
	
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NegocioException.class)    
    public ApiError DominioNoEncontradoException(HttpServletRequest req, NegocioException excepcion){
        return new ApiError(HttpStatus.NOT_FOUND, excepcion.getMessage());
    }
    
    @ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErroresResponse handleValidationExceptions(HttpServletRequest req,
	  MethodArgumentNotValidException ex) {
	    ErroresResponse errores = new ErroresResponse();    
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	    	errores.addError(new ErrorResponse( error.getDefaultMessage()));
	    });
	    errores.getErrores().sort(Comparator.comparing(a -> a.getError()));
	    return errores;
	}
}

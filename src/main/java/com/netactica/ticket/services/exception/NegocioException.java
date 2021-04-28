package com.netactica.ticket.services.exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -2712565483147481718L;

	public NegocioException(String errorMessage, Throwable err) {
      super(errorMessage, err);
  	}
	
	public NegocioException(String errorMessage) {
	      super(errorMessage);
  	}
	
}

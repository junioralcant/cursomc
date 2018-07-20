package com.webtolls.cursomc.services.exceptions;

public class ObjectNotFoundException  extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {// construtor com sobrecarga que recebe uma exceção que seria a 
																 //causa de alguma coisa que aconteceu antes
		super (msg, cause);
	}

}

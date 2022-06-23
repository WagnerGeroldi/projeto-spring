package com.projectcrud.exceptions;

public class ExceptionsNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionsNotFound() {
		super("Id não encontrado ");
	}

}

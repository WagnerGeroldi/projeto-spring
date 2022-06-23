package com.projectcrud.exceptionResponseDetails;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorUserEmpty extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorUserEmpty(String message) {
		super(message);
	}

}

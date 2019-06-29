package br.com.or.sigeb.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.authentication.BadCredentialsException;

import br.com.or.sigeb.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResouceExceptionHandlers {
	

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFoundHandler(ObjectNotFoundException e, HttpServletRequest request) {
		StandartError error = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.valueOf(error.getStatus())).body(error);
	}
}

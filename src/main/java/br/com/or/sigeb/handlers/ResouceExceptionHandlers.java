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
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException(BadCredentialsException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(401l);
		erro.setMessage("Usuário ou senha inválidos");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/401");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);

	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFoundHandler(ObjectNotFoundException e, HttpServletRequest request) {
		StandartError error = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.valueOf(error.getStatus())).body(error);
	}
}

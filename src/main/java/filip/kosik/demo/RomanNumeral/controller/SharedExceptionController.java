package filip.kosik.demo.RomanNumeral.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class SharedExceptionController {

	private final static Logger LOGGER = LogManager.getLogger(SharedExceptionController.class);

	// Note: If application needs different behavior for IllegalArgumentException, it has to be replaced in RomanNumeralConverter with custom exception.
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handle(IllegalArgumentException ex, WebRequest request) {
		LOGGER.warn(ex.getMessage());
		LOGGER.debug(ex);
		return ex.getMessage();
	}
	
}

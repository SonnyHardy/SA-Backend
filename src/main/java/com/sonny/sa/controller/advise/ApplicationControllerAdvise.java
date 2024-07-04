package com.sonny.sa.controller.advise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sonny.sa.dto.ErrorEntity;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class ApplicationControllerAdvise {

	@ExceptionHandler({EntityNotFoundException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorEntity handleException(EntityNotFoundException exception) {
		return new ErrorEntity(null, exception.getMessage());
	}
	
	
	@ExceptionHandler({RuntimeException.class})
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public @ResponseBody ErrorEntity handleRuntimeException(EntityNotFoundException exception) {
		return new ErrorEntity(null, exception.getMessage());
	}
}

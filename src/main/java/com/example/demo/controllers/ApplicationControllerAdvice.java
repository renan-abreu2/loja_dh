package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javassist.NotFoundException;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public Map<String, Object> handleNotFoundException(NotFoundException ex) {
		Map<String, Object> resposta = new HashMap<>();
		resposta.put("mensagem", ex.getMessage());
		resposta.put("status", "error");
		resposta.put("code", 404);
		return resposta;
	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(
//	  MethodArgumentNotValidException ex) {
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.put(fieldName, errorMessage);
//	    });
//	    return errors;
//	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, Object> resposta = new HashMap<>();
		resposta.put("mensagem", "Argumento inválido");
		resposta.put("code", 400);
		resposta.put("status", "error");
		resposta.put("erros",
				ex.getBindingResult().getFieldErrors().stream().map(
						error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
						.collect(Collectors.toList()));

		return resposta;
	}
}

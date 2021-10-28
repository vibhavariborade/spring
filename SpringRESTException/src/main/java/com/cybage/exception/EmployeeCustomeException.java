package com.cybage.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class EmployeeCustomeException {
	@ExceptionHandler((RecordNotFoundException.class))
	@ResponseBody
	public String handleException(RecordNotFoundException exception)
	{
		return exception.getMessage();
	}
}

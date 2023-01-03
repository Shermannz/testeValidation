package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class testeValid implements ConstraintValidator<teste, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		String v = value == null ? "" : value;
		
		return v.matches("^[A-Z]+(.)*");
	}

}

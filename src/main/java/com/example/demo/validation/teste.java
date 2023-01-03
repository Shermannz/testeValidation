package com.example.demo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Documented
@Constraint(validatedBy = testeValid.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface teste {
	
	String message() default "Só começando com letra maiuscula";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}

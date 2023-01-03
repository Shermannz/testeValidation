package com.example.demo.resources;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.TesteV;
import com.example.demo.service.TesteVService;

@RestController
@RequestMapping(value = "/teste")
public class TesteVResource {
	
	@Autowired
	TesteVService service;
	
	@GetMapping
	public ResponseEntity<List<TesteV>> findAll(){
		List<TesteV> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<TesteV> insert(@Valid @RequestBody TesteV v){
		v = service.insert(v);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(v.getId()).toUri();
		return ResponseEntity.created(uri).body(v);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handlevalidation(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String name = ((FieldError) error).getField();
			String errorz = error.getDefaultMessage();
			errors.put(name, errorz);
		});
		
		
		return errors;
	}
	

}

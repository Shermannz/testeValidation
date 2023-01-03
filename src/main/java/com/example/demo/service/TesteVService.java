package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.TesteV;
import com.example.demo.repositories.TesteVRepository;

@Service
public class TesteVService {

	@Autowired
	public TesteVRepository repository;
	
	public List<TesteV> findAll(){
       List<TesteV> list  = repository.findAll();
       return list;
	}
	
	public TesteV insert(TesteV v) {
		TesteV t = new TesteV();
		t.setTeste(v.getTeste());
		t = repository.save(t);
		return t;
	}
	
	
}

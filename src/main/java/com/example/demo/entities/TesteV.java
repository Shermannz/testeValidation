package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.validation.teste;


@Entity
@Table(name = "teste")
public class TesteV implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@teste
	@NotBlank
	private String teste;
	
	public TesteV() {
	}


	public TesteV(Long id, String teste) {
		super();
		this.id = id;
		this.teste = teste;
	}


	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(teste);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TesteV other = (TesteV) obj;
		return Objects.equals(teste, other.teste);
	}

	
}

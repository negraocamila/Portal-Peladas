package com.peladas.portal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="convidado")
public class Convidado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@NotEmpty
	@Column(name = "rg")
	private String rg;
	
	@NotEmpty
	@Column(name = "nomeConvidado")
	private String nomeConvidado;
	
	
	@ManyToOne
	private Peladas peladas;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	public Peladas getPeladas() {
		return peladas;
	}

	public void setPeladas(Peladas peladas) {
		this.peladas = peladas;
	}

	
	
}

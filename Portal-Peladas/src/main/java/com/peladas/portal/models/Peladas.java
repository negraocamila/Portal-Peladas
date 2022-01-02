package com.peladas.portal.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;


@Entity
public class Peladas {

	    @Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id")
		private long id;
		
		@Column(name = "nome")
		@NotEmpty
		private String nome;
		
		@Column(name = "data")
		@NotEmpty
		private String data;
		
		@Column(name = "hora")
		@NotEmpty
		private String hora;
		
		@Column(name = "local")
		@NotEmpty
		private String local;
		
		@OneToMany
		private List<Convidado>convidado;
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getHora() {
			return hora;
		}
		public void setHora(String hora) {
			this.hora = hora;
		}
		public String getLocal() {
			return local;
		}
		public void setLocal(String local) {
			this.local = local;
		}
}

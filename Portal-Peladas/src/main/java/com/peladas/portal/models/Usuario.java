package com.peladas.portal.models;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@NotEmpty(message="Nome completo é obrigatorio")
	@Column(name = "nomecompleto")
	private String nomeCompleto;
	
	@Email(message = "Email invalido")
	@NotEmpty(message="Email é obrigatorio")
	@Column(name = "email")
	private String email;
	
	@Size(min=3, max= 20, message= "Apelido deve conter entre 3 a 20 caracteres")
	@NotEmpty(message="Apelido é obrigatorio")
	@Column(name = "apelido")
	private String apelido;
		
	@NotEmpty(message="Senha é obrigatorio")
	@Size(min=5, message="Senha deve conter no minimo 5 caracteres")
	@Column(name = "password")
	private String senha;
	

	@Column(name = "status")
	private String status;
	
	
	@ManyToMany
	@JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}

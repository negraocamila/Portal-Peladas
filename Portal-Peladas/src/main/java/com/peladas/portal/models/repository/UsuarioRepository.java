package com.peladas.portal.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.peladas.portal.models.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, String> {

public Usuario findByApelido(String apelido);
	
	@Query("select i from Usuario i where i.email = :email")
	public Usuario findByEmail(String email);
	
	@Query("select j from Usuario j where j.apelido = :apelido and j.senha = :senha")
	public Usuario buscarLogin(String apelido, String senha);
}

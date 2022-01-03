package com.peladas.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peladas.portal.models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
	
	
}

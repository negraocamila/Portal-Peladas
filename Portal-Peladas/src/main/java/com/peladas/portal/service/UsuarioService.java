package com.peladas.portal.service;

import com.peladas.portal.models.Usuario;


public interface UsuarioService {

	public void saveUsuario(Usuario usuario);
	public boolean isUserAlreadyPresent(Usuario usuario);
	
}

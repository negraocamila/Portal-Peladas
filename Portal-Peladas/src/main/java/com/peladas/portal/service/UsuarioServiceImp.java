package com.peladas.portal.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.peladas.portal.models.Role;
import com.peladas.portal.models.Usuario;
import com.peladas.portal.repository.RoleRepository;
import com.peladas.portal.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository rr;
	@Autowired
	UsuarioRepository ur;
	
	@Override
	public void saveUsuario(Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		usuario.setStatus("VERIFIED");
		Role usuarioRole = rr.findByRole("SITE_USER");
		usuario.setRoles(new HashSet<Role>(Arrays.asList(usuarioRole)));
		ur.save(usuario);

	}

	@Override
	public boolean isUserAlreadyPresent(Usuario usuario) {
		boolean isUserAlreadyExists = false;
		Usuario existingUser = ur.findByEmail(usuario.getEmail());
		if(existingUser != null){
			isUserAlreadyExists = true; 
		}
		return isUserAlreadyExists;
	}

}

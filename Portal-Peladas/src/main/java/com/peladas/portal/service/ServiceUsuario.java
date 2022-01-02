package com.peladas.portal.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peladas.portal.exceptions.CriptoExistsException;
import com.peladas.portal.exceptions.EmailExistsException;
import com.peladas.portal.models.Usuario;
import com.peladas.portal.models.repository.UsuarioRepository;
import com.peladas.portal.util.Util;


@Service
public class ServiceUsuario {

	@Autowired
	private UsuarioRepository ur;
	
	public void salvarUsuario(Usuario usuario) throws Exception{
		
		try {
			
			if(ur.findByEmail(usuario.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para : " + usuario.getEmail());
			}
			
			usuario.setSenha(Util.md5(usuario.getSenha()));
			
		} catch (NoSuchAlgorithmException e) {
			throw new CriptoExistsException("Erro na criptografia da senha");
			
		}
		
		ur.save(usuario);
	}
	
	public Usuario loginUser(String usuario, String senha) throws ServiceExc{
		
		Usuario userLogin = ur.buscarLogin(usuario, senha);
		return userLogin;
	}
}

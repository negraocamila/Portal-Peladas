package com.peladas.portal.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.peladas.portal.models.Usuario;
import com.peladas.portal.models.repository.UsuarioRepository;
import com.peladas.portal.service.ServiceExc;
import com.peladas.portal.service.ServiceUsuario;
import com.peladas.portal.util.Util;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private ServiceUsuario su;
	
			
	
	@GetMapping("/login")
	public ModelAndView login() {
	ModelAndView mv= new ModelAndView();
	mv.setViewName("/login");
	return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
	
	
	
	
	@GetMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("/cadastro");
		return mv;
	}
	
	@PostMapping("salvarUsuario")
	public ModelAndView cadastro(Usuario usuario) {
		ModelAndView mv= new ModelAndView();
		ur.save(usuario);
		mv.setViewName("redirect:/login");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc{
		ModelAndView mv= new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("/login");
		}
		
		Usuario userLogin = su.loginUser(usuario.getApelido(), Util.md5(usuario.getSenha()));
			if(userLogin == null) {
				mv.addObject("msg", "Usuario nao encontrado. Tente novamente");
			}else {
				session.setAttribute("usuarioLogado", userLogin);
				return index();
			}
			
			return mv;
	}
	
	
	
}

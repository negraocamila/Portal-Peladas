package com.peladas.portal.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.peladas.portal.models.Usuario;
import com.peladas.portal.service.UsuarioService;


@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService us;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {
		ModelAndView modelAndView = new ModelAndView();
		 Usuario usuario = new Usuario();
		 modelAndView.addObject("usuario", usuario); 
		modelAndView.setViewName("cadastro"); 
		return modelAndView;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index"); 
		return modelAndView;
	}
	
		
	@RequestMapping(value="/cadastro", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid Usuario usuario, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
			if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Por favor corrija os campos!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		else if(us.isUserAlreadyPresent(usuario)){
			modelAndView.addObject("successMessage", "Usuario ja existe!");			
		}
		else {
			us.saveUsuario(usuario);
			modelAndView.addObject("successMessage", "Usuario cadastrado com sucesso!");
		}
		modelAndView.addObject("usuario", new Usuario());
		modelAndView.setViewName("cadastro");
		return modelAndView;
	}
	
}

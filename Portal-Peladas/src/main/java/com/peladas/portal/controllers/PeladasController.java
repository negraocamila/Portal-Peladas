package com.peladas.portal.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.peladas.portal.models.Convidado;
import com.peladas.portal.models.Peladas;
import com.peladas.portal.repository.ConvidadoRepository;
import com.peladas.portal.repository.PeladasRepository;



@Controller
public class PeladasController {

	@Autowired
	private PeladasRepository pr;
	
	@Autowired
	private ConvidadoRepository cr;
	
	
	
	@RequestMapping(value="/cadastrarPelada", method=RequestMethod.GET)
		public String form() {
		return "peladas/formPeladas";
	}
	
	@RequestMapping(value="/cadastrarPelada", method=RequestMethod.POST)
	public String form(@Valid Peladas peladas, BindingResult result, RedirectAttributes attributes ) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarPelada";
		}
		
		pr.save(peladas);
		attributes.addFlashAttribute("mensagem", "Pelada adicionada com sucesso!");
		return "redirect:/cadastrarPelada";
	}
	
	@RequestMapping("/peladas")
	public ModelAndView listaPeladas() {
		ModelAndView mv = new ModelAndView("peladas/listaPeladas");
		Iterable<Peladas> peladas = pr.findAll();
		mv.addObject("peladas", peladas);
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesPeladas(@PathVariable("id") long id) {
		Peladas peladas = pr.findByid(id);
		ModelAndView mv = new ModelAndView("peladas/detalhesPeladas");
		mv.addObject("peladas", peladas);
		
		Iterable<Convidado> convidado = cr.findByPeladas(peladas);
		mv.addObject("convidado", convidado);
		
		return mv;
	}
	
	@RequestMapping("/deletarPelada")
	public String deletarPelada(long id) {
		Peladas peladas = pr.findByid(id);
		pr.delete(peladas);
		return "redirect:/peladas";
		
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String detalhesPeladasPost(@PathVariable("id") long id, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{id}";
		}
		Peladas peladas = pr.findByid(id);
		convidado.setPeladas(peladas);
		cr.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{id}";
	}
	
	@RequestMapping("/deletarConvidado")
	public String deletarConvidado(String rg) {
		Convidado convidado = cr.findByRg(rg);
		cr.delete(convidado);
		
		Peladas peladas = convidado.getPeladas();
		long idLong = peladas.getId();
		String id = " " + idLong;
		return "redirect:/" + id;
		
	}
}

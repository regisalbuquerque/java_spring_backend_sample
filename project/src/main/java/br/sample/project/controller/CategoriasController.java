package br.sample.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.sample.project.repository.CategoriasRepository;

@Controller
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping("/categorias")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaCategorias");
		modelAndView.addObject("categorias", categoriasRepository.findAll());
		return modelAndView;
	}

}

package br.sample.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.sample.project.model.Categoria;
import br.sample.project.repository.CategoriasRepository;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaCategorias");
		modelAndView.addObject("categorias", categoriasRepository.findAll());
		modelAndView.addObject(new Categoria());
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("ListaCategorias");
		modelAndView.addObject("categorias", categoriasRepository.findAll());
		modelAndView.addObject(new Categoria());
		return modelAndView;
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("ListaCategorias");
		modelAndView.addObject("categorias", categoriasRepository.findAll());
		modelAndView.addObject("categoria", categoriasRepository.findById(id.longValue()));
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("ListaCategorias");
		Categoria categoria = categoriasRepository.findById(id.longValue()).get();
		categoriasRepository.delete(categoria);
		
		modelAndView.addObject("categorias", categoriasRepository.findAll());
		modelAndView.addObject(new Categoria());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Categoria categoria) {
		categoriasRepository.save(categoria);
		return "redirect:/categorias";
	}

}

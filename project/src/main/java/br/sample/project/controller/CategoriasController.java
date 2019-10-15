package br.sample.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriasController {
	
	@GetMapping("/categorias")
	public String listar() {
		return "ListaCategorias";
	}

}

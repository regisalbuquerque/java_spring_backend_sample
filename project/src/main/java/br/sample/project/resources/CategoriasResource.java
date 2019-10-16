package br.sample.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sample.project.model.Categoria;
import br.sample.project.repository.CategoriasRepository;

@RestController
@RequestMapping(value="api/categorias")
public class CategoriasResource {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> list = categoriasRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = categoriasRepository.findById(id.longValue()).get();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
		obj = categoriasRepository.save(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id.longValue());
		obj = categoriasRepository.save(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Categoria obj = categoriasRepository.findById(id.longValue()).get();
		try {
			categoriasRepository.delete(obj);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}

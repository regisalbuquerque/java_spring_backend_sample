package br.sample.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sample.project.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long>{

}

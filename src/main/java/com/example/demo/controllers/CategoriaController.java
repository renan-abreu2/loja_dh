package com.example.demo.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

import com.example.demo.entity.Categoria;
import com.example.demo.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping // listar todos
	public ResponseEntity<List<Categoria>> index() {
		List<Categoria> categorias = categoriaService.getAll();
		return ResponseEntity.ok(categorias);
	}

	@PostMapping // cadastrar
	@Transactional
	public ResponseEntity<Categoria> store(@Valid @RequestBody Categoria categoria) {
		Categoria entity = categoriaService.store(categoria);
		return ResponseEntity.ok(entity);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> show(@PathVariable(value = "id") Integer id) {
		Categoria entity = categoriaService.getOne(id);
		return ResponseEntity.ok(entity);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Categoria> update(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody Categoria categoria) {
		Categoria entity = categoriaService.update(id, categoria);
		return ResponseEntity.ok(entity);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> destroy(@PathVariable(value = "id") Integer id) {
		categoriaService.destroy(id);
		return ResponseEntity.noContent().build();
	}

}

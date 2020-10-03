package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Categoria;

import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> getAll() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}

	public Categoria store(Categoria categoria) {
		Categoria novo = categoriaRepository.save(categoria);
		return novo;
	}

	public Categoria getOne(Integer id) {
		Optional<Categoria> entity = categoriaRepository.findById(id);
		if (entity.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "categoria não foi encontrada!");
		}
		Categoria categoria = entity.get();
		return categoria;
	}

	public Categoria update(Integer id, Categoria categoria) {
		this.getOne(id);
		categoria.setId(id);
		Categoria novaCategoria = this.store(categoria);
		return novaCategoria;
	}

	public void destroy(Integer id) {
		Categoria categoria = this.getOne(id);
		categoriaRepository.delete(categoria);
	}

}

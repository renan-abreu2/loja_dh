package resources;

import java.util.List;
import java.util.Optional;

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

import javassist.NotFoundException;

public abstract class BaseController<E extends BaseEntity, R extends BaseRepository<E>> {
	
	@Autowired
	private R repository;

	@GetMapping // listar todos
	public ResponseEntity<List<E>> index() {
		List<E> clientes = repository.findAll();
		return ResponseEntity.ok(clientes);
	}

	@PostMapping // cadastra cliente
	@Transactional
	public ResponseEntity<E> store(@Valid @RequestBody E cliente) {
		E novoE = repository.save(cliente);
		return ResponseEntity.ok(novoE);
	}

	@GetMapping("/{id}") // detalha entidade
	public ResponseEntity<E> show(@PathVariable(value = "id") Integer id) throws NotFoundException {
		Optional<E> optionalEntity = repository.findById(id);
		if (optionalEntity.isEmpty()) {
			throw new NotFoundException("Entidade não encontrado!");
		}
		E entity = optionalEntity.get();
		return ResponseEntity.ok(entity);
	}

	@PutMapping("/{id}") // atualiza entidade
	@Transactional
	public ResponseEntity<E> update(@Valid @PathVariable(value = "id") Integer id, @RequestBody E entity)
			throws NotFoundException {
		Optional<E> optionalEntity = repository.findById(id);
		if (optionalEntity.isEmpty()) {
			throw new NotFoundException("Entidade não encontrado!");
		}
		entity.setId(id);
		E clienteAtualizado = repository.save(entity);
		return ResponseEntity.ok(clienteAtualizado);
	}

	@DeleteMapping("/{id}") // deleta entidade
	@Transactional
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) throws NotFoundException {
		Optional<E> entity = repository.findById(id);
		if (entity.isEmpty()) {
			throw new NotFoundException("Entidade não encontrado!");
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

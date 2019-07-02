package br.com.or.sigeb.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.or.sigeb.domain.Turma;
import br.com.or.sigeb.domain.dto.TurmaDTO;
import br.com.or.sigeb.services.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class TurmaResource {
	@Autowired
	TurmaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Turma> getTurmaById(@PathVariable Long id) {
		Turma obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<TurmaDTO>> findAll() {
		List<Turma> obj = new ArrayList<>();
		obj = service.findAll();
		List<TurmaDTO> objDTO = obj.stream().map(x -> new TurmaDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(objDTO);
	}

	@PostMapping
	public ResponseEntity<Turma> insert(@Valid @RequestBody Turma turma) {

		Turma obj = service.save(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Turma> removeById(Long id) {
		Turma obj = service.findById(id);
		service.removeById(obj.getId());
		return ResponseEntity.ok().build();
	}
}

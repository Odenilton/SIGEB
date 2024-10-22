package br.com.or.sigeb.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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

import br.com.or.sigeb.domain.Aluno;
import br.com.or.sigeb.services.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {

	@Autowired
	AlunoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> obj = new ArrayList<>();
		obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno) {

		Aluno obj = service.save(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Aluno> removeById(Long id) {
		Aluno obj = service.findById(id);
		service.removeById(obj.getId());
		return ResponseEntity.ok().build();
	}

}

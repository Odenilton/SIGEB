package br.com.or.sigeb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.or.sigeb.domain.Turma;
import br.com.or.sigeb.exceptions.ObjectNotFoundException;
import br.com.or.sigeb.repositories.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository repo;

	public Turma findById(Long id) {
		Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Entity id: " + id + " not found. Exception class: " + Turma.class.toString()));
	}

	public List<Turma> findAll() {
		return repo.findAll();
	}

	public Turma save(Turma turma) {
		turma.setId(null);
		return repo.save(turma);
	}

	public void update(Turma turma) {
		Turma obj = findById(turma.getId());
		obj = turma;
		repo.save(obj);
	}

	public void removeById(Long id) {
		Turma obj = findById(id);
		repo.delete(obj);
	}
}
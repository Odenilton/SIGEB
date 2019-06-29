package br.com.or.sigeb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.or.sigeb.domain.Aluno;
import br.com.or.sigeb.exceptions.ObjectNotFoundException;
import br.com.or.sigeb.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repo;

	public Aluno findById(Long id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object id: " + id + " not found. exception class: " + Aluno.class.toString()));
	}
	
	public Aluno save(Aluno aluno) {
		aluno.setId(null);
		return repo.save(aluno);
	}

	public void update(Aluno aluno) {
		Aluno obj = findById(aluno.getId());
		obj = aluno;
		repo.save(obj);
	}

	public void removeById(Long id) {
		Aluno obj = findById(id);
		repo.delete(obj);
	}
}

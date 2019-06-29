package br.com.or.sigeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.or.sigeb.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

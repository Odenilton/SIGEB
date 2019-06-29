package br.com.or.sigeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.or.sigeb.domain.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
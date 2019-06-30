package br.com.or.sigeb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.or.sigeb.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
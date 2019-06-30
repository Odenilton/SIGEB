package br.com.or.sigeb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.or.sigeb.domain.Usuario;
import br.com.or.sigeb.exceptions.ObjectNotFoundException;
import br.com.or.sigeb.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UsuarioRepository repo;

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Entity id: " + id + " not found. Exception class: " + Usuario.class.toString()));
	}
	
	public Usuario save(Usuario usuario) {
		usuario.setId(null);
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		return repo.save(usuario);
	}

	public void update(Usuario usuario) {
		Usuario obj = findById(usuario.getId());
		obj = usuario;
		repo.save(obj);
	}

	public void removeById(Long id) {
		Usuario obj = findById(id);
		repo.delete(obj);
	}
}

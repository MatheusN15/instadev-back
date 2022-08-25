package br.com.mathe.instadev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mathe.instadev.entity.Usuario;
import br.com.mathe.instadev.exception.ObjectNotFoundException;
import br.com.mathe.instadev.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Usuario save(Usuario obj) {
		return obj = repo.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		return obj = repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}

package br.com.mathe.instadev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mathe.instadev.entity.Comentario;
import br.com.mathe.instadev.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository repo;
	
	public Comentario findById(Long id) {
		Optional<Comentario> obj = repo.findById(id);
		return obj.get();
	}
	
	public List<Comentario> findAll() {
		return repo.findAll();
	}
	
	public Comentario save(Comentario obj) {
		return obj = repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}

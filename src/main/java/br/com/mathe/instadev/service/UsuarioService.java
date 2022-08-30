package br.com.mathe.instadev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mathe.instadev.entity.Usuario;
import br.com.mathe.instadev.entity.dto.UsuarioDTO;
import br.com.mathe.instadev.entity.dto.UsuarioSearchDTO;
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
	
	public Usuario update(UsuarioDTO obj) {
		Usuario usu = findById(obj.getId());
		usu.setNome(obj.getNome());
		usu.setUsername(obj.getUsername());
		usu.setDescricao(obj.getDescricao());
		usu.setEmail(obj.getEmail());
		return repo.save(usu);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Page<Usuario> searchByUsername(String username, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Usuario> list = repo.findDistinctByUsernameContainingIn(username, pageRequest);
		return list;
	}
}

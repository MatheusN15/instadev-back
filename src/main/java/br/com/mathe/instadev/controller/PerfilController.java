package br.com.mathe.instadev.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mathe.instadev.entity.Usuario;
import br.com.mathe.instadev.entity.dto.UsuarioDTO;
import br.com.mathe.instadev.entity.dto.UsuarioSearchDTO;
import br.com.mathe.instadev.service.UsuarioService;

@RestController()
@RequestMapping(value = "/perfil")
public class PerfilController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> getPerfilById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> savePerfil(@RequestBody Usuario usu) {
		usu = service.save(usu);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usu.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> updatePerfil(@PathVariable(name = "id") Long id, @RequestBody UsuarioDTO obj) {
		obj.setId(id);
		Usuario usu = service.update(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usu.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ResponseEntity<Page<UsuarioSearchDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@RequestParam(value="username", defaultValue="") String username) {
		Page<Usuario> list = service.searchByUsername(username,page, linesPerPage, orderBy, direction);
		Page<UsuarioSearchDTO> listDto = list.map(obj -> new UsuarioSearchDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}

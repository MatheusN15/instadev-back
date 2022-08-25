package br.com.mathe.instadev.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mathe.instadev.entity.Usuario;
import br.com.mathe.instadev.service.UsuarioService;

@RestController()
@RequestMapping(value = "/perfil")
public class PerfilController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> getPerfis() {
		List<Usuario> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> getPerfilById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> getNewPerfil(@RequestBody Usuario usu) {
		usu = service.save(usu);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usu.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

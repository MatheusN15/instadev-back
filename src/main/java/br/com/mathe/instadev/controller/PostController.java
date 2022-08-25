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

import br.com.mathe.instadev.entity.Comentario;
import br.com.mathe.instadev.entity.Post;
import br.com.mathe.instadev.service.ComentarioService;
import br.com.mathe.instadev.service.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	private PostService service;
	
	@Autowired
	private ComentarioService comentService;
	
	@GetMapping
	public List<Post> getPost() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Post getPostById(@PathVariable(name = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping(value = "/c")
	public List<Comentario> getComentarios() {
		return comentService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Post> getNewPost(@RequestBody Post obj) {
		obj = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

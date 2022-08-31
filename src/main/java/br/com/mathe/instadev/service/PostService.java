package br.com.mathe.instadev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mathe.instadev.entity.Curtida;
import br.com.mathe.instadev.entity.Post;
import br.com.mathe.instadev.entity.Usuario;
import br.com.mathe.instadev.entity.dto.PostCurtirDTO;
import br.com.mathe.instadev.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	@Autowired
	private UsuarioService usuService;
	
	public Post findById(Long id) {
		Optional<Post> obj = repo.findById(id);
		return obj.get();
	}
	
	public List<Post> findAll() {
		return repo.findAll();
	}
	
	public Post save(Post obj) {
		return obj = repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public void curtirPost(PostCurtirDTO obj) {
		
		Usuario usu = usuService.findById(obj.getIdLogado());
		Post post = findById(obj.getIdPost());
		
		List<Curtida> curt = post.getCurtidas();
		Curtida novaCurtida = new Curtida();
		novaCurtida.setUsuario(usu);
		curt.add(novaCurtida);
		
		post.setQuantidadeCurtidas(curt.size());
		post.setCurtidas(curt);
		save(post);
	}
}

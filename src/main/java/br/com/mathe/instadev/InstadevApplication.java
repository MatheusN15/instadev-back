package br.com.mathe.instadev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mathe.instadev.entity.Comentario;
import br.com.mathe.instadev.entity.Post;
import br.com.mathe.instadev.entity.Usuario;
import br.com.mathe.instadev.repository.ComentarioRepository;
import br.com.mathe.instadev.repository.PostRepository;
import br.com.mathe.instadev.repository.UsuarioRepository;

@SpringBootApplication
public class InstadevApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(InstadevApplication.class, args);
	}
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ComentarioRepository comentRepository;
	
	@Autowired
	private UsuarioRepository usuRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Comentario c1 = new Comentario();
		c1.setComentario("Show demais esse post");
		
		
		Post p1 = new Post();
		p1.setCurtidas(20);
		p1.setDataPostada(new Date("10/01/2022 11:15"));
		p1.setDescricao("post qualquer 1");
		p1.getComentarios().addAll(Arrays.asList(c1));
		
		
		Usuario u1 = new Usuario();
		u1.setEmail("math@gmail.com");
		u1.setDescricao("para testes");
		u1.setNome("Matheus");
		u1.getPosts().addAll(Arrays.asList(p1));
		
		c1.setPost(p1);
		p1.setUsuario(u1);
		
		usuRepository.save(u1);
		postRepository.save(p1);
		comentRepository.save(c1);
	}
}

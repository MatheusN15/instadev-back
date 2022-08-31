package br.com.mathe.instadev;

import java.util.Arrays;
import java.util.Date;

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
		p1.setQuantidadeCurtidas(20);
		p1.setDataPostada(new Date("10/01/2022 11:15"));
		p1.setDescricao("post qualquer 1");
		p1.getComentarios().addAll(Arrays.asList(c1));
		
		Post p2 = new Post();
		p1.setQuantidadeCurtidas(20);
		p1.setDataPostada(new Date("10/01/2022 11:15"));
		p1.setDescricao("post qualquer 1");
		p1.getComentarios().addAll(Arrays.asList(c1));
		
		Usuario u1 = new Usuario();
		u1.setEmail("math@gmail.com");
		u1.setDescricao("para testes");
		u1.setNome("Matheus");
		u1.getPosts().addAll(Arrays.asList(p1));
		
		Usuario u2 = new Usuario();
		u2.setEmail("mari@gmail.com");
		u2.setDescricao("para testes");
		u2.setNome("Mariana");
		u2.getPosts().addAll(Arrays.asList(p2));
		
		Usuario u3 = new Usuario();
		u3.setEmail("Cleitin@gmail.com");
		u3.setDescricao("para testes");
		u3.setNome("Cletin");
		
//		Seguidores seg = new Seguidores();
//		seg.setUsuario(u1);
//		Seguidores seg1 = new Seguidores();
//		seg1.setUsuario(u3);
		
		u2.setSeguidores(Arrays.asList(u1, u3));
		
		c1.setPost(p1);
		p1.setUsuario(u1);
		
		usuRepository.saveAll(Arrays.asList(u1,u2,u3));
		postRepository.saveAll(Arrays.asList(p1,p2));
		comentRepository.save(c1);
//		segRepository.saveAll(Arrays.asList(seg,seg1));
	}
}

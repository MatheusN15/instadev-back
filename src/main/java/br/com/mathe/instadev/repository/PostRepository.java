package br.com.mathe.instadev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mathe.instadev.entity.Post;
import br.com.mathe.instadev.entity.Usuario;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}

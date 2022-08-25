package br.com.mathe.instadev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mathe.instadev.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}

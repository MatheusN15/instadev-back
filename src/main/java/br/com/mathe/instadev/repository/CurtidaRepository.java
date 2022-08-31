package br.com.mathe.instadev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mathe.instadev.entity.Comentario;
import br.com.mathe.instadev.entity.Curtida;

@Repository
public interface CurtidaRepository extends JpaRepository<Curtida, Long>{

}

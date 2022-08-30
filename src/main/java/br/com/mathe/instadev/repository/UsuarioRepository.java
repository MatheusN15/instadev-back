package br.com.mathe.instadev.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mathe.instadev.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Usuario obj WHERE obj.username LIKE %:username%")
	Page<Usuario> findDistinctByUsernameContainingIn(@Param("username") String username, Pageable pageRequest);
}

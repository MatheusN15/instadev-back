package br.com.mathe.instadev.entity.dto;

import java.io.Serializable;

public class PostCurtirDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idLogado;
	private Long idSeguido;
	private Long idPost;
	
	public PostCurtirDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostCurtirDTO(Long idLogado, Long idSeguido, Long idPost) {
		super();
		this.idLogado = idLogado;
		this.idSeguido = idSeguido;
		this.idPost = idPost;
	}

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public Long getIdLogado() {
		return idLogado;
	}

	public void setIdLogado(Long idLogado) {
		this.idLogado = idLogado;
	}

	public Long getIdSeguido() {
		return idSeguido;
	}

	public void setIdSeguido(Long idSeguido) {
		this.idSeguido = idSeguido;
	}

}

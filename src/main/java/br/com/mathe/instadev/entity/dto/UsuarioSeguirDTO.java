package br.com.mathe.instadev.entity.dto;

import java.io.Serializable;

public class UsuarioSeguirDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idLogado;
	private Long idSeguido;
	
	public UsuarioSeguirDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioSeguirDTO(Long idLogado, Long idSeguido) {
		super();
		this.idLogado = idLogado;
		this.idSeguido = idSeguido;
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

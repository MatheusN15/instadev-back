package br.com.mathe.instadev.entity.dto;

import java.io.Serializable;

import br.com.mathe.instadev.entity.Usuario;

public class UsuarioSearchDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	
	public UsuarioSearchDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioSearchDTO(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public UsuarioSearchDTO(Usuario obj) {
		this.id = obj.getId();
		this.username = obj.getUsername();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

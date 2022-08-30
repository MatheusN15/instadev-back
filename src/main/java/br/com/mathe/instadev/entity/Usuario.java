package br.com.mathe.instadev.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String username;

	private String nome;
	
	@Column(unique=true)
	private String email;
	
	private String descricao;
	
	private Integer quantidadeSeguidores;
	
	private Integer quantidadeSeguindo;

	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="SEGUIDORES")
	private List<Long> seguidores = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="SEGUINDO")
	private List<Long> seguindo = new ArrayList<>();
	

	public Usuario(Long id, String nome, String email, String descricao, Integer quantidadeSeguidores, List<Long> seguidores, List<Long> seguindo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.quantidadeSeguidores = quantidadeSeguidores;
		this.seguidores = seguidores;
		this.seguindo = seguindo;
	}

	public Usuario() {
		super();
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Long> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Usuario> seguidores) {
		setQuantidadeSeguidores(seguidores.size());
		this.seguidores = seguidores.stream().map(t -> t.getId()).collect(Collectors.toList());
	}

	public Integer getQuantidadeSeguidores() {
		return quantidadeSeguidores;
	}

	private void setQuantidadeSeguidores(Integer quantidadeSeguidores) {
		this.quantidadeSeguidores = quantidadeSeguidores;
	}

	public List<Long> getSeguindo() {
		return seguindo;
	}

	public void setSeguindo(List<Usuario> seguindo) {
		setQuantidadeSeguindo(seguindo.size());
		this.seguindo = seguindo.stream().map(t -> t.getId()).collect(Collectors.toList());
	}

	public Integer getQuantidadeSeguindo() {
		return quantidadeSeguindo;
	}

	private void setQuantidadeSeguindo(Integer quantidadeSeguindo) {
		this.quantidadeSeguindo = quantidadeSeguindo;
	}
}

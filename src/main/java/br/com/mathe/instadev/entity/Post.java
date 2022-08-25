package br.com.mathe.instadev.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String descricao;	
	private Integer curtidas;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataPostada;
	
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL)
	private List<Comentario> comentarios = new ArrayList<>();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String descricao, Integer curtidas, Date dataPostada, List<Comentario> comentarios, Usuario usuario) {
		super();
		this.descricao = descricao;
		this.curtidas = curtidas;
		this.dataPostada = dataPostada;
		this.comentarios = comentarios;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataPostada() {
		return dataPostada;
	}

	public void setDataPostada(Date dataPostada) {
		this.dataPostada = dataPostada;
	}

	public Integer getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(Integer curtidas) {
		this.curtidas = curtidas;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}

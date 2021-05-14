package br.com.valterdacoregio.model;

import java.io.Serializable;

public class PessoaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipo;

	public PessoaModel() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

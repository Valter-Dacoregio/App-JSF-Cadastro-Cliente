package br.com.valterdacoregio.model.usuario;

import java.io.Serializable;

public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String login;
	private String senha;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
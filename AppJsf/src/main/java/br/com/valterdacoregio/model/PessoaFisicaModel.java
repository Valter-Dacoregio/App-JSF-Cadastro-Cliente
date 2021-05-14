package br.com.valterdacoregio.model;

import java.util.Date;

import br.com.valterdacoregio.utils.Utils;

public class PessoaFisicaModel extends PessoaModel {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String telefone;
	private String email;
	
	public PessoaFisicaModel() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDataNascimentoFormatada() {
		if (this.dataNascimento != null)
			return Utils.formata(this.dataNascimento, "dd/MM/yyyy");
		return "";
	}
}

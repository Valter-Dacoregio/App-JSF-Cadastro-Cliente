package br.com.valterdacoregio.model;

import java.util.List;

public class PessoaJuridicaModel extends PessoaModel {

	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private List<String> telefones;
	private String site;

	public PessoaJuridicaModel() {

	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
}

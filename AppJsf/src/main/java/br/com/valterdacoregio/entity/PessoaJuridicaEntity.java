package br.com.valterdacoregio.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;

@Entity
//@Table(name = "pessoa_juridica")
@DiscriminatorValue(value = "J")
public class PessoaJuridicaEntity extends PessoaEntity {

	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
	
	@Column(name = "razao_social")
	private String razaoSocial;
	
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	private String cnpj;
	
	@ElementCollection
	@JoinTable
	private List<String> telefones;
	
//	@OrderColumn
//	@IndexColumn
//	private String[] telefones;
	
	private String site;

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

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
//	
//	public String[] getTelefones() {
//		return telefones;
//	}
//	
//	public void setTelefones(String[] telefones) {
//		this.telefones = telefones;
//	}
	

	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}
}

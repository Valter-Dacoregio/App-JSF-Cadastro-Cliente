package br.com.valterdacoregio.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valterdacoregio.listFilter.PessoaFilter;
import br.com.valterdacoregio.model.PessoaFisicaModel;
import br.com.valterdacoregio.model.PessoaJuridicaModel;
import br.com.valterdacoregio.model.PessoaModel;
import br.com.valterdacoregio.repository.PessoaRepository;
import br.com.valterdacoregio.utils.Utils;

@Named(value = "consultaController")
//@RequestScoped
@ViewScoped
public class ConsultaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	List<PessoaModel> pessoas;
	PessoaModel pessoa;
	
	@Inject
	PessoaFilter pessoaFilter;
	
	@Inject
	PessoaRepository pessoaRepository;
	
	@PostConstruct
	public void carregar() {
		this.buscar();
	}
	
	public void buscar() {
		this.pessoas = this.pessoaRepository.listarModel(this.pessoaFilter);
	}
	
	public void prepareEditar() {
		try {
			String url = "/Appjsf/sistema/consulta.xhtml";
			if (this.pessoa instanceof PessoaFisicaModel) {
				url = "/Appjsf/sistema/cadastroPF.xhtml";
			} else if (this.pessoa instanceof PessoaJuridicaModel) {
				url = "/Appjsf/sistema/cadastroPJ.xhtml";
			}
			
			FacesContext.getCurrentInstance().getExternalContext().redirect(url + "?id=" + this.pessoa.getId());
		} catch (IOException e) {
			Utils.MensagemAtencao("Ocorreu um erro ao tentar editar");
			e.printStackTrace();
		}
	}
	
	public void prepareExcluir(PessoaModel pessoaModel) {
		this.pessoa = pessoaModel;
	}

	public void excluir() {
		this.pessoaRepository.excluir(this.pessoa);
		
		Utils.MensagemInfo("Pessoa excluida com sucesso");
		
		this.buscar();
	}
	
	public List<PessoaModel> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaModel> pessoas) {
		this.pessoas = pessoas;
	}

	public PessoaModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaFilter getPessoaFilter() {
		return pessoaFilter;
	}

	public void setPessoaFilter(PessoaFilter pessoaFilter) {
		this.pessoaFilter = pessoaFilter;
	}
}

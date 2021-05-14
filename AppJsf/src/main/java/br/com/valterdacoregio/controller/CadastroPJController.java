package br.com.valterdacoregio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valterdacoregio.entity.PessoaJuridicaEntity;
import br.com.valterdacoregio.model.PessoaJuridicaModel;
import br.com.valterdacoregio.repository.PessoaJuridicaRepository;
import br.com.valterdacoregio.repository.PessoaRepository;
import br.com.valterdacoregio.utils.Utils;

@Named(value = "cadastroPJController")
//@RequestScoped
@ViewScoped
public class CadastroPJController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	PessoaJuridicaModel pessoaJuridicaModel;
	
	String telefone;
	
	@Inject
	PessoaRepository pessoaRepository;
	@Inject
	PessoaJuridicaRepository pessoaJuridicaRepository;
	
	@PostConstruct
	public void carregar() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = requestMap.get("id");
		
		this.limpar();
		
		// EDITANDO UM REGISTRO
		if(id != null) {
			Integer idPJ = Integer.parseInt(id);
			PessoaJuridicaEntity entity = (PessoaJuridicaEntity) pessoaRepository.buscar(idPJ);
			this.pessoaJuridicaModel = pessoaJuridicaRepository.entityToModel(entity);
		}
	}
	
	private void limpar() {
		this.pessoaJuridicaModel = new PessoaJuridicaModel();
		this.pessoaJuridicaModel.setTelefones(new ArrayList<String>());
	}
	
	public void adicionarTelefone() {
		if(this.telefone.trim().isEmpty()) {
			Utils.MensagemAtencao("Informe o Telefone");
			return;
		}
		if(!this.pessoaJuridicaModel.getTelefones().contains(this.telefone)) {
			this.pessoaJuridicaModel.getTelefones().add(this.telefone);
		}
		this.telefone = "";
	}
	
	public void removerTelefone() {
		this.pessoaJuridicaModel.getTelefones().remove(this.telefone);
	}
	
	public void salvar() {
		try {
			if(pessoaJuridicaModel.getId() == null) {
				
				pessoaJuridicaRepository.salvarNovoRegistro(pessoaJuridicaModel);
				Utils.MensagemInfo("PJ cadastrada com sucesso");
			} else {
				pessoaJuridicaRepository.alterar(pessoaJuridicaModel);
				Utils.MensagemInfo("PJ editada com sucesso");
				
//				String url = "/Appjsf/sistema/cadastroPJ.xhtml";
//				FacesContext.getCurrentInstance().getExternalContext().redirect(url);
			}
			
			this.limpar();
		} catch (Exception e) {
			Utils.MensagemAtencao("Ocorreu um erro ao salvar/editar");
			e.printStackTrace();
		}
	}

	public PessoaJuridicaModel getPessoaJuridicaModel() {
		return pessoaJuridicaModel;
	}

	public void setPessoaJuridicaModel(PessoaJuridicaModel pessoaJuridicaModel) {
		this.pessoaJuridicaModel = pessoaJuridicaModel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

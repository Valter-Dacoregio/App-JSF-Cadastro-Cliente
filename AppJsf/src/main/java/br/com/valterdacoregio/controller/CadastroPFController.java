package br.com.valterdacoregio.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valterdacoregio.entity.PessoaFisicaEntity;
import br.com.valterdacoregio.model.PessoaFisicaModel;
import br.com.valterdacoregio.repository.PessoaFisicaRepository;
import br.com.valterdacoregio.repository.PessoaRepository;
import br.com.valterdacoregio.utils.Utils;

@Named(value = "cadastroPFController")
//@RequestScoped
@ViewScoped
public class CadastroPFController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	PessoaFisicaModel pessoaFisicaModel;
	
	@Inject
	PessoaRepository pessoaRepository;
	@Inject
	PessoaFisicaRepository pessoaFisicaRepository;
	
	@PostConstruct
	public void carregar() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = requestMap.get("id");
		
		// EDITANDO UM REGISTRO
		if(id != null) {
			Integer idPF = Integer.parseInt(id);
			PessoaFisicaEntity entity = (PessoaFisicaEntity) pessoaRepository.buscar(idPF);
			this.pessoaFisicaModel = pessoaFisicaRepository.entityToModel(entity);
		}
	}
	
	private void limpar() {
		pessoaFisicaModel = new PessoaFisicaModel();
	}
	
	public void salvar() {
		try {
			if(pessoaFisicaModel.getId() == null) {
				pessoaFisicaRepository.salvarNovoRegistro(pessoaFisicaModel);
				Utils.MensagemInfo("PF cadastrada com sucesso");
			} else {
				pessoaFisicaRepository.alterar(pessoaFisicaModel);
				Utils.MensagemInfo("PF editada com sucesso");
				
//				String url = "/Appjsf/sistema/cadastroPF.xhtml";
//				FacesContext.getCurrentInstance().getExternalContext().redirect(url);
			}
			this.limpar();
		} catch (Exception e) {
			Utils.MensagemAtencao("Ocorreu um erro ao salvar/editar");
			e.printStackTrace();
		}
	}

	public PessoaFisicaModel getPessoaFisicaModel() {
		return pessoaFisicaModel;
	}

	public void setPessoaFisicaModel(PessoaFisicaModel pessoaFisicaModel) {
		this.pessoaFisicaModel = pessoaFisicaModel;
	}

	public PessoaFisicaRepository getPessoaFisicaRepository() {
		return pessoaFisicaRepository;
	}

	public void setPessoaFisicaRepository(PessoaFisicaRepository pessoaFisicaRepository) {
		this.pessoaFisicaRepository = pessoaFisicaRepository;
	}
}

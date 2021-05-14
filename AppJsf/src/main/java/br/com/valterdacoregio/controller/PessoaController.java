package br.com.valterdacoregio.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.valterdacoregio.utils.Utils;

@Named(value = "pessoaController")
//@RequestScoped
@ViewScoped
public class PessoaController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void carregar() {
		
	}
	
	public void irParaPF() {
		try {
			String url = "/Appjsf/sistema/cadastroPF.xhtml";
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			Utils.MensagemAtencao("Ocorreu um erro ao tentar ir para o cadastro");
			e.printStackTrace();
		}
	}
	
	public void irParaPJ() {
		try {
			String url = "/Appjsf/sistema/cadastroPJ.xhtml";
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			Utils.MensagemAtencao("Ocorreu um erro ao tentar ir para o cadastro");
			e.printStackTrace();
		}
	}
}

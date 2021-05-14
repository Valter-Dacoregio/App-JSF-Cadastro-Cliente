package br.com.valterdacoregio.controller.usuario;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.valterdacoregio.repository.usuario.UsuarioRepository;
import br.com.valterdacoregio.entity.usuario.UsuarioEntity;
import br.com.valterdacoregio.model.usuario.UsuarioModel;
import br.com.valterdacoregio.utils.Utils;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioModel usuarioModel;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Inject
	private UsuarioEntity usuarioEntity;

	public UsuarioModel GetUsuarioSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (UsuarioModel) facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado");
	}

	public String Logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}

	public String logar() {
		if (StringUtils.isEmpty(usuarioModel.getLogin()) || StringUtils.isBlank(usuarioModel.getLogin())) {
			Utils.Mensagem("Favor informar o login!");
			return null;
		} else if (StringUtils.isEmpty(usuarioModel.getSenha()) || StringUtils.isBlank(usuarioModel.getSenha())) {
			Utils.Mensagem("Favor informar a senha!");
			return null;
		} else {
			usuarioEntity = usuarioRepository.ValidaUsuario(usuarioModel);
			
			if (usuarioEntity != null) {
				usuarioModel.setSenha(null);
				usuarioModel.setId(usuarioEntity.getId());

				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", usuarioModel);
				return "sistema/pessoa?faces-redirect=true";
			} else {
				Utils.Mensagem("Não foi possível efetuar o login com esse usuário e senha!");
				return null;
			}
		}
	}
	
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
}
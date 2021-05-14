package br.com.valterdacoregio.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

public class Utils {

	public static EntityManager JpaEntityManager() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		EntityManager aux = (EntityManager) request.getAttribute("entityManager");
		return aux;
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit_app");
//		this.entityManagerFactory = Persistence.createEntityManagerFactory(this.persistence_unit_name); 
//		EntityManager em = factory.createEntityManager();
//		return em;
	}

	// MOSTRAR MENSAGEM
	public static void Mensagem(String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage("Alerta", mensagem));
	}

	// MOSTRAR MENSAGEM
	public static void MensagemAtencao(String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", mensagem));
	}

	// MOSTRAR MENSAGEM
	public static void MensagemInfo(String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
	}
	
	public static String formata(Date data, String formato){
		String retorno = "";
		if(data !=null){
			SimpleDateFormat sf  = new SimpleDateFormat(formato);			
			retorno=sf.format(data);
		}
		return retorno;
	}
}

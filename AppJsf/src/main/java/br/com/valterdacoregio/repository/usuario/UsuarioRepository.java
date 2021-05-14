package br.com.valterdacoregio.repository.usuario;

import java.io.Serializable;

import javax.persistence.Query;

import br.com.valterdacoregio.entity.usuario.UsuarioEntity;
import br.com.valterdacoregio.model.usuario.UsuarioModel;
import br.com.valterdacoregio.utils.Utils;
 
 
public class UsuarioRepository implements Serializable {
 
 
	private static final long serialVersionUID = 1L;
 
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel){
 
		try {
//			/*
			
			//QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser) 	
			Query query = Utils.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
//			Query query = Utils.JpaEntityManager().createNamedQuery("findUser");
//			Query query = Utils.JpaEntityManager().createQuery("SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.senha = :senha");
//			Query query = Utils.JpaEntityManager().createNativeQuery("SELECT u FROM tb_usuario u WHERE u.ds_usuario = :usuario AND u.ds_senha = :senha");
//			Query query = Utils.JpaEntityManager().createNativeQuery("SELECT u FROM tb_usuario u WHERE u.ds_usuario = :usuario AND u.ds_senha = :senha");
//			Query query = Utils.JpaEntityManager().createNativeQuery("SELECT u FROM tb_usuario u WHERE u.ds_usuario = :usuario AND u.ds_senha = :senha", UsuarioEntity.class);
 
			//PARÂMETROS DA QUERY
			query.setParameter("login", usuarioModel.getLogin());
			query.setParameter("senha", usuarioModel.getSenha());
// 
			//RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (UsuarioEntity)query.getSingleResult();
			
//			*/
			
			
			/*
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit_app");
			EntityManager em = factory.createEntityManager();
//			EntityManager em = Utils.JpaEntityManager();
			em.getTransaction().begin();
			
			Query query = em.createQuery("SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario AND u.senha = :senha");
//			Query query = em.createNativeQuery("SELECT u FROM tb_usuario u WHERE u.ds_login = ? AND u.ds_senha = ? ");
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
//			query.setParameter(1, usuarioModel.getUsuario());
//			query.setParameter(2, usuarioModel.getSenha());
			
			UsuarioEntity retorno = (UsuarioEntity) query.getSingleResult();
			
			em.getTransaction().commit();
			em.close();
			
			return retorno;
			
			*/
 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
 
 
 
	}
}
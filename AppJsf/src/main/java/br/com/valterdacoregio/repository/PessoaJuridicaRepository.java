package br.com.valterdacoregio.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.valterdacoregio.entity.PessoaJuridicaEntity;
import br.com.valterdacoregio.model.PessoaJuridicaModel;
import br.com.valterdacoregio.utils.Utils;

public class PessoaJuridicaRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	PessoaJuridicaEntity pessoaJuridicaEntity;
	
	EntityManager entityManager;
	
	public void salvarNovoRegistro(PessoaJuridicaModel pessoaJuridicaModel) {
		this.entityManager = Utils.JpaEntityManager();
		
		this.pessoaJuridicaEntity = this.modelToEntity(pessoaJuridicaModel);
		
		this.entityManager.persist(this.pessoaJuridicaEntity);
	}
	
	public void alterar(PessoaJuridicaModel pessoaJuridicaModel) {
		this.entityManager = Utils.JpaEntityManager();
		
		this.pessoaJuridicaEntity = this.modelToEntity(pessoaJuridicaModel);
		
	    this.entityManager.merge(pessoaJuridicaEntity);
	    this.entityManager.flush();
	}
	
	public PessoaJuridicaModel entityToModel(PessoaJuridicaEntity entity) {
		PessoaJuridicaModel model = new PessoaJuridicaModel();
		model.setId(entity.getId());
		model.setTipo(entity.getTipo());
		model.setRazaoSocial(entity.getRazaoSocial());
		model.setNomeFantasia(entity.getNomeFantasia());
		model.setCnpj(entity.getCnpj());
		model.setTelefones(entity.getTelefones()); // TODO: ADICIONAR
		model.setSite(entity.getSite());
		return model;
	}
	
	public PessoaJuridicaEntity modelToEntity(PessoaJuridicaModel model) {
		PessoaJuridicaEntity entity = new PessoaJuridicaEntity();
		entity.setId(model.getId());
		entity.setTipo(model.getTipo());
		entity.setRazaoSocial(model.getRazaoSocial());
		entity.setNomeFantasia(model.getNomeFantasia());
		entity.setCnpj(model.getCnpj());
		entity.setTelefones(model.getTelefones());
//		entity.setTelefones(Arrays.asList("aaaa","bbbb")); // TODO: REMOVER
		entity.setSite(model.getSite());
		return entity;
	}
}

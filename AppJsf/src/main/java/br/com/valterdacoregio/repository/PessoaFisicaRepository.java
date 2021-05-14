package br.com.valterdacoregio.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.valterdacoregio.entity.PessoaFisicaEntity;
import br.com.valterdacoregio.model.PessoaFisicaModel;
import br.com.valterdacoregio.utils.Utils;

public class PessoaFisicaRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	PessoaFisicaEntity pessoaFisicaEntity;
	
	EntityManager entityManager;
	
	public void salvarNovoRegistro(PessoaFisicaModel pessoaFisicaModel) {
		this.pessoaFisicaEntity = this.modelToEntity(pessoaFisicaModel);

		this.entityManager = Utils.JpaEntityManager();
		this.entityManager.persist(this.pessoaFisicaEntity);
	}
	
	public void alterar(PessoaFisicaModel pessoaFisicaModel) {
		this.pessoaFisicaEntity = this.modelToEntity(pessoaFisicaModel);
		
		this.entityManager = Utils.JpaEntityManager();
	    this.entityManager.merge(pessoaFisicaEntity);
	    this.entityManager.flush();
	}
	
	public PessoaFisicaModel entityToModel(PessoaFisicaEntity entity) {
		PessoaFisicaModel model = new PessoaFisicaModel();
		model.setId(entity.getId());
		model.setTipo(entity.getTipo());
		model.setNome(entity.getNome());
		model.setCpf(entity.getCpf());
		model.setDataNascimento(entity.getDataNascimento());
		model.setTelefone(entity.getTelefone());
		model.setEmail(entity.getEmail());
		return model;
	}
	
	public PessoaFisicaEntity modelToEntity(PessoaFisicaModel model) {
		PessoaFisicaEntity entity = new PessoaFisicaEntity();
		entity.setId(model.getId());
		entity.setTipo(model.getTipo());
		entity.setNome(model.getNome());
		entity.setCpf(model.getCpf());
		entity.setDataNascimento(model.getDataNascimento());
		entity.setTelefone(model.getTelefone());
		entity.setEmail(model.getEmail());
		return entity;
	}
}

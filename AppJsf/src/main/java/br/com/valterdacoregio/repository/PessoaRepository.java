package br.com.valterdacoregio.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.valterdacoregio.entity.PessoaEntity;
import br.com.valterdacoregio.entity.PessoaFisicaEntity;
import br.com.valterdacoregio.entity.PessoaJuridicaEntity;
import br.com.valterdacoregio.listFilter.PessoaFilter;
import br.com.valterdacoregio.model.PessoaFisicaModel;
import br.com.valterdacoregio.model.PessoaJuridicaModel;
import br.com.valterdacoregio.model.PessoaModel;
import br.com.valterdacoregio.utils.Utils;

public class PessoaRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	PessoaFisicaEntity pessoaFisicaEntity;
	
	@Inject
	PessoaFisicaRepository pessoaFisicaRepository;
	@Inject
	PessoaJuridicaRepository pessoaJuridicaRepository;
	
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	private List<PessoaEntity> listarEntity(PessoaFilter pessoaFilter) {
		
	    String queryString = "SELECT p FROM PessoaEntity p WHERE 1=1";
	    
	    // CARREGA OS FILTROS PREENCHIDOS
	    Map<String, Object> map = new HashMap<>();
	    if(pessoaFilter != null) {
		    if(pessoaFilter.getNome() != null && !pessoaFilter.getNome().trim().isEmpty()) {
		    	queryString += " AND nome = :nome";
		    	map.put("nome", pessoaFilter.getNome());
		    }
		    if(pessoaFilter.getRazaoSocial() != null && !pessoaFilter.getRazaoSocial().trim().isEmpty()) {
		    	queryString += " AND razaoSocial = :razaoSocial";
		    	map.put("razaoSocial", pessoaFilter.getRazaoSocial());
		    }
		    if(pessoaFilter.getNomeFantasia() != null && !pessoaFilter.getNomeFantasia().trim().isEmpty()) {
		    	queryString += " AND nomeFantasia = :nomeFantasia";
		    	map.put("nomeFantasia", pessoaFilter.getNomeFantasia());
		    }
		    if(pessoaFilter.getCpf() != null && !pessoaFilter.getCpf().trim().isEmpty()) {
		    	queryString += " AND cpf = :cpf";
		    	map.put("cpf", pessoaFilter.getCpf());
		    }
		    if(pessoaFilter.getCnpj() != null && !pessoaFilter.getCnpj().trim().isEmpty()) {
		    	queryString += " AND cnpj = :cnpj";
		    	map.put("cnpj", pessoaFilter.getCnpj());
		    }
	    }
	    
	    this.entityManager = Utils.JpaEntityManager();
	    Query query = this.entityManager.createQuery(queryString);
	    
	    // ATRIBUI OS FILTROS PREENCHIDOS
	    for(Entry<String, Object> item : map.entrySet()) {
	    	query.setParameter(item.getKey(), item.getValue());
	    }
	    
	    return (List<PessoaEntity>) query.getResultList();
	}
	

	public List<PessoaModel> listarModel(PessoaFilter pessoaFilter) {
		List<PessoaEntity> listaEntity = this.listarEntity(pessoaFilter);
		List<PessoaModel> listaModel = new ArrayList<PessoaModel>();
		
		if(listaEntity != null) {
			for(PessoaEntity item : listaEntity) {
				if(item.getTipo().equals("F")) {
					PessoaFisicaEntity pfEntity = (PessoaFisicaEntity) item;
					PessoaFisicaModel pf = pessoaFisicaRepository.entityToModel(pfEntity);
					listaModel.add(pf);
				} else if(item.getTipo().equals("J")) {
					PessoaJuridicaEntity pjEntity = (PessoaJuridicaEntity) item;
					PessoaJuridicaModel pj = pessoaJuridicaRepository.entityToModel(pjEntity);
					listaModel.add(pj);
				}
			}
		}
		
		return listaModel;
	}
	
	public PessoaEntity buscar(Integer id) {
		this.entityManager = Utils.JpaEntityManager();
		
		String queryString = "SELECT p FROM PessoaEntity p WHERE id = :id";
		Query query = this.entityManager.createQuery(queryString);
		query.setParameter("id", id);
		
		return (PessoaEntity) query.getSingleResult();
	}

	public void excluir(PessoaModel pessoa) {
		this.entityManager = Utils.JpaEntityManager();
		
		PessoaEntity pessoaEntity = this.buscar(pessoa.getId());
		if(pessoaEntity != null) {
			this.entityManager.remove(pessoaEntity);
		}
	}
}

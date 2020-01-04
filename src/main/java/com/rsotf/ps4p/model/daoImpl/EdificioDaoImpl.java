package com.rsotf.ps4p.model.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rsotf.ps4p.model.dao.IEdificioDao;
import com.rsotf.ps4p.model.entity.EdificioEntity;

@Repository
public class EdificioDaoImpl implements IEdificioDao {

	@PersistenceContext 
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<EdificioEntity> listAll() {
		
		return em.createQuery("from EdificioEntity").getResultList();
	}


	@Override
	@Transactional
	public void save(EdificioEntity edificio) {
		
		em.persist(edificio);
	}

}

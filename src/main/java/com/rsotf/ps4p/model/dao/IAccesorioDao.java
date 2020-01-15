package com.rsotf.ps4p.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsotf.ps4p.model.entity.AccesorioEntity;

public interface IAccesorioDao extends JpaRepository<AccesorioEntity, Long>{
	
	 
	public List<AccesorioEntity> findByNombreLikeIgnoreCase(String name);
	
	public AccesorioEntity findByNumInventario(String serial);
}

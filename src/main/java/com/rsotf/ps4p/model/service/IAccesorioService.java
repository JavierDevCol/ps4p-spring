package com.rsotf.ps4p.model.service;

import java.util.List;

import com.rsotf.ps4p.model.entity.AccesorioEntity;

public interface IAccesorioService {

	public AccesorioEntity findById(Long id);
	
	public List<AccesorioEntity> findByNombreLikeIgnoreCase(String name);
	
	public void save(AccesorioEntity accesorio);
	
	public AccesorioEntity findByNumInventario(String serial);
	
	public List<AccesorioEntity> findAll();
}

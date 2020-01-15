package com.rsotf.ps4p.model.service;

import java.util.List;

import com.rsotf.ps4p.model.entity.AccesorioEntity;
import com.rsotf.ps4p.model.entity.SalaEntity;

public interface ISalaService {
	
	public SalaEntity findById(Long id);
	
	public void save(SalaEntity sala);
	
	public void delete(Long id);
	
	public List<AccesorioEntity> findByNombreLikeIgnoreCase(String name);

}

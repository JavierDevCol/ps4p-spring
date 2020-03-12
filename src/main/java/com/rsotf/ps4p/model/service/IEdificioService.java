package com.rsotf.ps4p.model.service;

// import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rsotf.ps4p.model.entity.EdificioEntity;

public interface IEdificioService {

	//public List<EdificioEntity> listAll();
	
	public Page<EdificioEntity> listAll(Pageable pageable);
	
	public void save( EdificioEntity edificio);
	
	public EdificioEntity findById(Long id);
	
	public void delete(Long id);
}

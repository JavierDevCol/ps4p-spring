package com.rsotf.ps4p.model.dao;

import java.util.List;

import com.rsotf.ps4p.model.entity.EdificioEntity;

public interface IEdificioDao {

	public List<EdificioEntity> listAll();
	
	public void save( EdificioEntity edificio);
}

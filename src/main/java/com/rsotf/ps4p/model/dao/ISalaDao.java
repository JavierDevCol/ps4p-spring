package com.rsotf.ps4p.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.rsotf.ps4p.model.entity.SalaEntity;

public interface ISalaDao extends JpaRepository<SalaEntity, Long>{

	
	public Optional<SalaEntity> findById(String id);
	
}

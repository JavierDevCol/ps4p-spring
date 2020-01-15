package com.rsotf.ps4p.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsotf.ps4p.model.dao.IAccesorioDao;
import com.rsotf.ps4p.model.dao.ISalaDao;
import com.rsotf.ps4p.model.entity.AccesorioEntity;
import com.rsotf.ps4p.model.entity.SalaEntity;
import com.rsotf.ps4p.model.service.ISalaService;

@Service
public class SalaServiceImpl implements ISalaService{

	@Autowired
	private ISalaDao salaDao;
	
	@Autowired
	private IAccesorioDao accesorioDao;
	
	@Override
	@Transactional(readOnly = true)
	public SalaEntity findById(Long id) {		
		return salaDao.findById(id).orElse(null);
	}

	@Override
	public void save(SalaEntity sala) {
		// TODO Auto-generated method stub
		salaDao.save(sala);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		salaDao.deleteById(id);
	}

	@Override
	@Transactional()
	public List<AccesorioEntity> findByNombreLikeIgnoreCase(String name) {
		// TODO Auto-generated method stub
		return accesorioDao.findByNombreLikeIgnoreCase(name);
	}

}

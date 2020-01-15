package com.rsotf.ps4p.model.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsotf.ps4p.model.dao.IAccesorioDao;
import com.rsotf.ps4p.model.entity.AccesorioEntity;
import com.rsotf.ps4p.model.service.IAccesorioService;

@Service
public class AccesorioServiceImpl implements IAccesorioService{

	@Autowired
	private IAccesorioDao accesorioDao;
	
	
	@Override
	public AccesorioEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void save(AccesorioEntity accesorio) {
		accesorioDao.save(accesorio);
		
	}

	@Override
	public List<AccesorioEntity> findByNombreLikeIgnoreCase(String name) {
		
		return accesorioDao.findByNombreLikeIgnoreCase(name);
	}


	@Override
	public AccesorioEntity findByNumInventario(String serial) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<AccesorioEntity> findAll() {
		
		return accesorioDao.findAll();
	}

	
}

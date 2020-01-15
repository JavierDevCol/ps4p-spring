package com.rsotf.ps4p.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsotf.ps4p.model.dao.IEdificioDao;
import com.rsotf.ps4p.model.entity.EdificioEntity;
import com.rsotf.ps4p.model.service.IEdificioService;

@Service
public class EdificioServiceImpl implements IEdificioService {

	@Autowired
	private IEdificioDao edificioDao;
	
//	@Override
//	@Transactional(readOnly = true)
//	public List<EdificioEntity> listAll() {
//		return (List<EdificioEntity>) edificioDao.findAll();
//	}

	@Override
	@Transactional
	public void save(EdificioEntity edificio) {
		edificioDao.save(edificio);
	}

	@Override
	@Transactional(readOnly = true)
	public EdificioEntity findById(Long id) {
		return edificioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		edificioDao.deleteById(id);
		
	}

	@Override
	public Page<EdificioEntity> listAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return edificioDao.findAll(pageable);
	}

}

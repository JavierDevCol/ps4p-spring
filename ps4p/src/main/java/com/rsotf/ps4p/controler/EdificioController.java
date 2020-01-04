package com.rsotf.ps4p.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rsotf.ps4p.model.dao.IEdificioDao;
import com.rsotf.ps4p.model.entity.EdificioEntity;

@Controller
@RequestMapping("/edificio")
public class EdificioController {

	@Autowired
	private IEdificioDao edificioDao;
	
	@GetMapping("/list")
	public String listAll(Model model){
		
		model.addAttribute("titulo", "Listado de Edificios");
		model.addAttribute("edificios", edificioDao.listAll());
		
		return "listarEdificio";
	}
	
	
	@GetMapping("/form")
	public String formCrearEdif(Model model){
		
		EdificioEntity edificio = new EdificioEntity();
		model.addAttribute("edificio", edificio);
		model.addAttribute("response", "Crear nuevo Edificio");
		return "home";
	}
	
	@PostMapping("/save")
	public String save(EdificioEntity edificio) {
		edificioDao.save(edificio);
		return "redirect:/edificio/list";
	}
}

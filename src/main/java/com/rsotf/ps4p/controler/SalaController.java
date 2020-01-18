package com.rsotf.ps4p.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rsotf.ps4p.model.entity.EdificioEntity;
import com.rsotf.ps4p.model.entity.SalaEntity;
import com.rsotf.ps4p.model.entity.AccesorioEntity;
import com.rsotf.ps4p.model.service.IEdificioService;
import com.rsotf.ps4p.model.service.ISalaService;

@Controller

@SessionAttributes("sala")
@RequestMapping("/salas")
public class SalaController {

	@Autowired
	private IEdificioService edificioService;
	
	@Autowired
	private ISalaService salaService;


	@GetMapping("/form/{edificioId}")
	public String form(@PathVariable(value = "edificioId") Long edificioId, Model model) {

		EdificioEntity edificio = edificioService.findById(edificioId);
		if (edificio == null) {
			return "redirect:/edificio/list";
		}
		SalaEntity sala = new SalaEntity();
		sala.setEdificio(edificio);
		model.addAttribute("sala", sala);
		model.addAttribute("titulo", "Crear Sala");
		//model.addAttribute("listEdi", listEdificio());
		return "sala/verSala";
	}

	@GetMapping(value = "/cargarAccesorios/{name}", produces = { "aplication/json" })
	public @ResponseBody List<AccesorioEntity> cargarAccesorios(@PathVariable String name) {
		return salaService.findByNombreLikeIgnoreCase(name);
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("sala") SalaEntity sala, RedirectAttributes flash,SessionStatus status) {		
		if (sala.getId() == null) {
			flash.addFlashAttribute("success", "Sala Creado con Exito");
		}else {
			flash.addFlashAttribute("success", "Sala Editada con Exito");
		}
		salaService.save(sala);
		status.setComplete();		
		return "redirect:/salas/list";
	}
	
	@GetMapping("/list")
	public String listAll(Model model) {		
		model.addAttribute("salas", salaService.findAll());
		model.addAttribute("titulo", "Listado de Salas");
		return "sala/listarSalas";
	}
	
	public List<String> listEdificio(){		
		List<String> list = null;
		List<EdificioEntity> ed = salaService.findEdificioAll();
		for (EdificioEntity string : ed) {
			list.add(string.getNombre());
		}				
		return list;
	}
	
	@GetMapping("/formE/{id}")
	 public String edit(@PathVariable(value = "id") Long id, Model model ) {
		 
		 SalaEntity sala = null;
		 if (id > 0 ) {
			sala = salaService.findById(id);
		}else {
			return "redirect:/list";
		}
		 model.addAttribute("sala", sala);
		 model.addAttribute("titulo","Editar Sala");
		 return "sala/verSala";
	 }
	
	@GetMapping("/verSala/{idSala}")
	public String verSala(@PathVariable(value = "idSala") Long id, Model model) {
		SalaEntity sala = salaService.findById(id);
		model.addAttribute("sala", sala);
		model.addAttribute("titulo", "Informacion de Sala ");		
		return "sala/verSala";
	}
}

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rsotf.ps4p.model.entity.AccesorioEntity;
import com.rsotf.ps4p.model.entity.EdificioEntity;
import com.rsotf.ps4p.model.service.IAccesorioService;

@Controller
@RequestMapping("/accesorios")
public class AccesorioController {

	@Autowired
	private IAccesorioService accesorioService;
	
	@GetMapping("/list")
	public String findAll(Model model) {
		
		
		model.addAttribute("titulo", "Listado de Edificios");
		model.addAttribute("acces", accesorioService.findAll());
		return "accesorio/listarAccesorios";
	}
	
	@GetMapping("/findByNombre/{name}")
	public String findByNombre(@PathVariable(value = "name") String name) {
		
		List<AccesorioEntity> acce = accesorioService.findByNombreLikeIgnoreCase(name);
		if (acce != null) {
			System.out.println("existe");
		}else {
		System.out.println("no existe");
		}
		return "";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("edificio") AccesorioEntity acces, RedirectAttributes flash,SessionStatus status) {

		accesorioService.save(acces);
		status.setComplete();
		flash.addFlashAttribute("success", "Accesorio Creado con Exito");
		return "redirect:/edificio/list";
		
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		AccesorioEntity acces = new AccesorioEntity();
		model.addAttribute("acces", acces);
		model.addAttribute("titulo", "Crear nuevo Accesorio");
		return "accesorios/form";
	}
	
	
}

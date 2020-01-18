package com.rsotf.ps4p.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rsotf.ps4p.model.entity.EdificioEntity;
import com.rsotf.ps4p.model.service.IEdificioService;
import com.rsotf.ps4p.utils.PageRender;

@Controller
@SessionAttributes("edificio")
@RequestMapping("/edificio")
public class EdificioController {

	@Autowired
	private IEdificioService edificioService;
	
	@GetMapping("/list")
	public String listAll(@RequestParam(name="page", defaultValue = "0") int page, Model model){
		
		Pageable pageRequest =  PageRequest.of(page, 5);
		Page<EdificioEntity> pageEdificio = edificioService.listAll(pageRequest);
		PageRender<EdificioEntity> pageRedner = new PageRender<>("", pageEdificio);
		model.addAttribute("titulo", "Listado de Edificios");
		model.addAttribute("edificios", pageEdificio);
		model.addAttribute("page", pageRedner);
		
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
	public String save(@Valid @ModelAttribute("edificio") EdificioEntity edificio, RedirectAttributes flash,SessionStatus status) {
		
		edificioService.save(edificio);
		status.setComplete();
		flash.addFlashAttribute("success", "Edificio Creado con Exito");
		return "redirect:/edificio/list";
	}
	
	 @GetMapping("/form/{id}")
	 public String edit(@PathVariable(value = "id") Long id, Model model ) {
		 
		 EdificioEntity edificio = null;
		 if (id > 0 ) {
			edificio = edificioService.findById(id);
		}else {
			return "redirect:/list";
		}
		 model.addAttribute("edificio", edificio);
		 model.addAttribute("response","Editar Edificio");
		 return "home";
	 }
	 
	 @GetMapping("/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
		 
		 if (id > 0) {
			 edificioService.delete(id);
		}
		 return "redirect:/edificio/list";
	 }
}

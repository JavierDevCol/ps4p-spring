package com.rsotf.ps4p.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsotf.ps4p.model.entity.EdificioEntity;
import com.rsotf.ps4p.model.entity.SalaEntity;
import com.rsotf.ps4p.model.entity.AccesorioEntity;
import com.rsotf.ps4p.model.service.IAccesorioService;
import com.rsotf.ps4p.model.service.IEdificioService;
import com.rsotf.ps4p.model.service.ISalaService;

@Controller
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
		return "sala/form";
	}

	@GetMapping(value = "/cargarAccesorios/{name}", produces = { "aplication/json" })
	public @ResponseBody List<AccesorioEntity> cargarAccesorios(@PathVariable String name) {
		return salaService.findByNombreLikeIgnoreCase(name);
	}
	
	@GetMapping("/formP/{id}")
	 public String edit(@PathVariable(value = "id") Long id, Model model ) {
		 
		 SalaEntity sala = null;
		 if (id > 0 ) {
			sala = salaService.findById(id);
		}else {
			return "redirect:/list";
		}
		 model.addAttribute("sala", sala);
		 model.addAttribute("titulo","popo SALA");
		 return "sala/form";
	 }
	
	
	@GetMapping("/edificios")
	public String listEdificio(Model model){
		
		List<String> list = null;
		List<EdificioEntity> ed = salaService.findEdificioAll();
		for (EdificioEntity string : ed) {
			list.add(string.getNombre());
		}
		
		model.addAttribute("edificios", list);
		
		return "";
	}
}

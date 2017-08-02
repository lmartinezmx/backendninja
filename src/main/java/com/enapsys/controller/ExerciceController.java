package com.enapsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.enapsys.service.ExerciceService;

@Controller
@RequestMapping("/ejercicio")
public class ExerciceController {
	private static final String EXERCICE_VIEW = "exercice";
	
	@Autowired
	@Qualifier("exerciceService")
	private ExerciceService exerciceService;
	
	@GetMapping("/")
	public RedirectView redirectMethod(){
		return new RedirectView("/ejercicio/segundoPath");
	}
	
	@GetMapping("/segundoPath")
	public String segundoMethod(Model model){
		exerciceService.showString();
		model.addAttribute("mensaje", exerciceService.showString());
		return 	EXERCICE_VIEW;
	}

}

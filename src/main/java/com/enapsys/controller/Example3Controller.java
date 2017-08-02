package com.enapsys.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.enapsys.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	/*
	//Redirect 1
	@GetMapping("/")
	public String redirect(){
		return "redirect:/example3/showform";
	}
	*/
	
	//Redirect 2
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/example3/showform");
	}
	
	
	
	@GetMapping("/showform")
	public String showForm(Model model){
		LOGGER.info("entrado a show form");
		LOGGER.debug("solo en debug");
		model.addAttribute("person", new Person());
		//int i = 5/0; cause error
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
		//LOGGER.info("Method add person, Attributes:" + person);
		ModelAndView mav = new ModelAndView(RESULT_VIEW);		
		if(bindingResult.hasErrors()){
			mav.setViewName(FORM_VIEW);
		}else{
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person );
		}
		//LOGGER.info("TEMPLATE "+ RESULT_VIEW + " Data "+ person);
		return mav;
	}

}

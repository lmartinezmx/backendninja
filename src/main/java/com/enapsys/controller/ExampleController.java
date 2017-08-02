package com.enapsys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.enapsys.component.ExampleComponent;
import com.enapsys.model.Person;
import com.enapsys.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//Primera Forma
	@GetMapping("/exampleString")
	//@RequestMapping(value="/exampleString", method= RequestMethod.GET)  //hace lo mismo que la de arriba
	public String exampleString(Model model){
		//model.addAttribute("name", "leo");
		//model.addAttribute("person", new Person("Leo", 30));
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}
	
	//Segunda forma
	@GetMapping("/exampleMAV")
	//@RequestMapping(value="/exampleMAV", method= RequestMethod.GET)
	public ModelAndView exampleMAV(){
		
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		//mav.addObject("person", new Person("LeoMAV", 30));
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}
}

package com.enapsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	private static final String VIEW = "404";
	
	@GetMapping("/notfound")
	public String notFoundError(){
		return "404";
	}
	
	@GetMapping("servererror")
	public String serverError(){
		return "500";
	}

}

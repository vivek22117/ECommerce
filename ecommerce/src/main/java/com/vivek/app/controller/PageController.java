package com.vivek.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv =  new ModelAndView("page");
		mv.addObject("greeting", "Welcome to MVC Project");
		return mv;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView greetings(@RequestParam("greeting")String greeting){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
}

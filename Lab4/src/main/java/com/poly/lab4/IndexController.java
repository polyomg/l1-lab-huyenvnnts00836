package com.poly.lab4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController{
	@RequestMapping("/home/index") 
	public String index(Model model) { 
	return "demo/home";
	} 
	@RequestMapping("/home/about") 
	public String about(Model model) {
	return "demo/about";
	}

}

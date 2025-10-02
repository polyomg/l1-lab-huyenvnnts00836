package com.poly.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lab2Controller {
	@RequestMapping("/menul2")
	public String show() {
		return"/menu";
	}
}

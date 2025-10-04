package com.poly.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	@RequestMapping("/poly/hello")
    public String sayHello(Model model) {
        model.addAttribute("title", "FPT Polytechnic");
        model.addAttribute("subject", "Spring Boot MVC - TS00836 Vũ Nguyễn Nhung Huyền");
        return "hello";
    }
}

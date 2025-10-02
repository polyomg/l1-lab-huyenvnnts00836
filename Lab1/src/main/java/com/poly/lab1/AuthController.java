package com.poly.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class AuthController {
	@Autowired
	private HttpServletRequest req;
	
	@GetMapping("/form")
	public String showForm() {
		return"poly/login";
	}
	
	@PostMapping("/check")
	public String form(Model model) {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		if ("poly".equals(userName) && "123".equals(password)) {
			model.addAttribute("message", "Bạn đã thành công");
			model.addAttribute("success", true);
		} else {
			model.addAttribute("message", "Bạn đã sai rồi");
			model.addAttribute("success", false);
		}
		return"poly/login";
	}
}

package com.poly.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rect")
public class RectangleCalController {
	@Autowired
	private HttpServletRequest req;
	
	@GetMapping("/form")
	public String showHtml() {
		return"poly/rectangleCal";
	}
	
	@PostMapping("/calc")
	public String cal(Model model) {
		String sideLengthA = req.getParameter("a");
		String sideLengthB = req.getParameter("b");
		double a = 0, b= 0;
		try {
			a = Double.parseDouble(sideLengthA);
			b = Double.parseDouble(sideLengthB);
		} catch (NumberFormatException e) {
			model.addAttribute("message", "Sai kiểu dữ liệu đầu vào");
			return"poly/rectangleCal";
		}
		double area = a * b;
		double perimeter = (a + b) * 2;
		model.addAttribute("width", a);
		model.addAttribute("height", b);
		model.addAttribute("area", area);
		model.addAttribute("perimeter", perimeter);
		return"poly/rectangleCal";
	}
}

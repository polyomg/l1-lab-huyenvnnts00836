package com.poly.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.poly.lab2.entity.Product;

@Controller
@RequestMapping("/product4")
public class ProductControllerBai4 {
	public List<Product> list = new ArrayList<>(Arrays.asList(new Product("A", 1.0), new Product("B", 12.0)));

	@GetMapping("/form4")
	public String form(Model model) {
		Product p = new Product();
		p.setName("iPhone 30");
		p.setPrice(5000.0);
		model.addAttribute("product", p);
		model.addAttribute("savedProduct", new Product());
		return "product/formB4";
	}

	@PostMapping("/save4")
	public String save(@ModelAttribute Product p, Model model) {
		//
		list.add(p);
		model.addAttribute("items", list);

		//
		model.addAttribute("savedProduct", p);
		return "product/formB4";
	}
}

package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@GetMapping("/form")
    public String form(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return "product/form";
    }
}

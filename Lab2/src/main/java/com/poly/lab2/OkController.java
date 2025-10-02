package com.poly.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ctrl")
public class OkController {
	@GetMapping("/ok")
    public String m2(@RequestParam(required = false) String x, Model model) {
        if (x != null) {
            return m3(model);
        } else {
            model.addAttribute("methodName", "m2");
        }
        return "ok";
    }

    @PostMapping("/ok")
    public String m1(@RequestParam(required = false) String action, 
                    @RequestParam(required = false) String x, Model model) {
        if (x != null) {
            return m3(model);
        } else {
            model.addAttribute("methodName", "m1");
        }
        return "ok";
    }

    public String m3(Model model) {
        model.addAttribute("methodName", "m3");
        return "ok";
    }
}

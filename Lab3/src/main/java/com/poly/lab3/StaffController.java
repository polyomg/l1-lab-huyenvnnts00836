package com.poly.lab3;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.lab3.entity.Staff;

@Controller
@RequestMapping("/staff")
public class StaffController {
	//B2
	@GetMapping("/list")
    public String list(Model model) {
        List<Staff> list = data();
        model.addAttribute("list", list);
        return "demo/staff-list";
    }
	//B4
	@GetMapping("/list/status") 
	public String listStatus(Model model) { 
		List<Staff> list = data();
		model.addAttribute("list", list); 
		return "demo/list-status"; 
	}
	//B5
	@GetMapping("/list/controls") 
	public String listControls(Model model) { 
	 List<Staff> list = data();
	 model.addAttribute("list", list); 
	 return "demo/list-controls"; 
	}
	
	
	public List<Staff> data() {
        return List.of(
            Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
            Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
            Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
            Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
            Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
            Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
        );
    }
}
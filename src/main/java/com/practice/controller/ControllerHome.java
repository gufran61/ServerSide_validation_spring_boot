package com.practice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.entity.LoginData;

@Controller
public class ControllerHome {
@GetMapping("/form")
	public String openForm(Model model) {
	System.out.println("done");
	model.addAttribute("loginData", new LoginData());
		return "form";
	}
//handler for process
@PostMapping("/process")
public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult br) {
	if(br.hasErrors()) {
		System.out.println(br);
		return "form";
	}
	return "success";
		
}
}

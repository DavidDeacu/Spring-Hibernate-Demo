package com.license.demo.login;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.license.demo.entity.Student;
import com.license.demo.entity.User;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		
		return "login-page";
	}
	
	@RequestMapping("/processLogin")
	public String processLoginForm(@Valid @ModelAttribute("user") User user, BindingResult theBindingResult, Model model) {
		model.addAttribute("student", new Student());
		
		if(LoginService.validateLogin(user.getUsername(), user.getPassword()) && !theBindingResult.hasErrors())
			return "catalog";
		
		model.addAttribute("loginError", "Invalid username or password");
		return "login-page";
	}
	
	//WhiteSpace passing the validation solve
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); // true - trim to null if the input has just white spaces
		
		//remove the leading and trailing whitespace
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}

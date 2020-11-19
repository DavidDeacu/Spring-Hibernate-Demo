package com.license.demo.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.license.demo.entity.Student;
import com.license.demo.entity.User;

@Controller
@RequestMapping("/catalog")
public class SearchController {
	
	@RequestMapping("/processSearch")
	public String processSearch(@ModelAttribute("student") Student student, @ModelAttribute("user") User user, Model model) {
		
		model.addAttribute("matchedStudent", SearchService.searchStudents(student.getFirstName(), student.getLastName(), student.getCity()));
		
		return "search-results";
	}

}

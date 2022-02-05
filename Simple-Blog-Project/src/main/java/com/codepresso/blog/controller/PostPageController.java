package com.codepresso.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostPageController {

	@GetMapping("/")
	public String getTodoListView() {
		return "index";
	}

	@RequestMapping("/index")
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping("/detail/{id}")
	public String getDetailPage(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id);
		return "detail";
	}
}

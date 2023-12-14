package com.example.albatross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;


@Controller	
@Log4j
@RequestMapping("/Albatross/*")
public class MainController {
	
	@GetMapping("/main")
	public void list() {
		System.out.println("이거 되나");
	}
}

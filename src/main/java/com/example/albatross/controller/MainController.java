package com.example.albatross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.albatross.service.TweetService;
import com.example.albatross.service.UserService;

import lombok.extern.log4j.Log4j;


@Controller	
@Log4j
@RequestMapping("/Albatross/*")
public class MainController {
	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private UserService userService;
	
	//User 계정으로만 진입가능
	@GetMapping("/main")
	public void doMain() {
		log.info("MainController에서 /main 진입");
	}
	
	@GetMapping("/tweetDetail")
	public void tweetDetail(Long tid, Model model) {
		log.info("MainContorller = /tweetDetail에 들어왔음 ");
		model.addAttribute("TweetDTO", tweetService.get(tid));
	}
	
	@GetMapping("/userDetail")
	public void userDetail(Long uuid, Model model) {
		log.info("MainContorller = /userDetail에 들어왔음 ");
		log.info("MainContorller = /userDetail uuid = " + uuid.getClass().getName());
		model.addAttribute("UserVO", userService.get(uuid));
	}
	
	@GetMapping("/edit")
	public void userEdit(Long uuid, Model model) {
		log.info("MainContorller = /edit에 들어왔음 ");
		log.info("MainContorller = /edit uuid = " + uuid);
		model.addAttribute("UserVO", userService.get(uuid));
	}
	
	@GetMapping("/search")
	public void search(String str, Model model) {
		log.info("MainContorller = /search에 들어왔음 ");
		log.info("MainContorller = /search str = " + str);
		model.addAttribute("str", str);
	}
	
	@GetMapping("/follow")
	public void follow() {
		log.info("MainContorller = /follow에 들어왔음 ");
	}
	
	//관리자 계정으로만 진입가능
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("MainController에서 /admin 진입");
	}
	
	//계정 없이 진입 가능
	@GetMapping("/register")
	public void doAccountRegister() {
		log.info("MainController에서 /accountRegiste 진입");
	}
	//---------------------------------CommonController-------------------------------------
	@GetMapping("/error")
	public void accessDenied(Authentication auth, Model model){		
		log.info("access Denied : " + auth);
		
		model.addAttribute("msg", "Access Denined");

	}
	
	@GetMapping("/Login")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " +logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Acccount");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	@GetMapping("/Logout")
	public void logoutGet() {
		log.info("loggout!!");
	}
}

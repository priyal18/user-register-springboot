package com.example.demo;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	@Autowired
	private UserRepository repo;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping("")
	public String viewHomePage()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String viewRegisterPage(Model model)
	{
		model.addAttribute("user",new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user)
	{
		String password = user.getPassword();
		System.out.println("password " + password);
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model)
	{
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/textPost")
	public String viewRichEditor(Model model)
	{
		model.addAttribute("post",new post());
		return "richEdit";
	}
	
	@PostMapping("/textarea")
	public String textArea(post p,Model model)
	{
		
		//System.out.println("request        " + request.getParameter("content"));
		System.out.println(p.getContent());
		model.addAttribute("pos",p);
		return "blogs";
	}
}

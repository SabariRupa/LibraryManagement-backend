package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Signup;
import com.example.demo.service.LoginService;


@RestController
@RequestMapping("/apiLogin")
public class LoginController {

	@Autowired 
	LoginService loginService;
	@GetMapping("/getInfo/{userName}")
	public Iterable<Signup> readByUserName(@PathVariable String userName)
	{
		return loginService.readByUserName(userName);
	}
}
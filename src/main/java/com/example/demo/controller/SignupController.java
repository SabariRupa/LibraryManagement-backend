package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Signup;
import com.example.demo.service.SignupService;
@RestController
@RequestMapping("/apisignup")
public class SignupController 
{
  @Autowired
  private SignupService signupService;
  
  @PostMapping("/")
  public String saveSignUp(@RequestBody Signup signUp)
  {
	  return signupService.saveSignUp(signUp);
	  //return "Thanks for signUp";
  }
}
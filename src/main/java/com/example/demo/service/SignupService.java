package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Signup;
import com.example.demo.repository.SignupRepository;

@Service
public class SignupService{
  @Autowired
  SignupRepository signupRepository;
  public String saveSignUp(Signup signUp)
  {
	  signupRepository.save(signUp);
	  return "Thanks for signUp";
  }
}
package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Signup;
import com.example.demo.repository.SignupRepository;

@Service
public class LoginService {

	@Autowired
	SignupRepository signupRepository;
	public Iterable<Signup> readByUserName(String userName)
	{
		return signupRepository.readByUserName(userName);
	}
}
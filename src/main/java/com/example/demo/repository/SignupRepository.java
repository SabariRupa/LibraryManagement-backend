package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Signup;

@Repository
public interface SignupRepository extends CrudRepository<Signup, String>{

	@Query("select s.userName,s.password from Signup s where s.userName=? 1")
	Iterable<Signup> readByUserName(String userName);
}
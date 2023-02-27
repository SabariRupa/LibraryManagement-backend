package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> ,PagingAndSortingRepository<Library, Integer>
{

}
package com.example.demo.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;


@Service
public class LibraryService {

	@Autowired
	  LibraryRepository libraryRepository;
	  
	  public Library create(Library book)
	  {
			return libraryRepository.save(book);
	  }
	  public Optional<Library> read(int id)
	  {
			return libraryRepository.findById(id);
	  }
	  public Library update(Library library)
	  {
			return libraryRepository.save(library);
	  }
	  public void delete(int id)
	  {
			libraryRepository.deleteById(id);
	  }
	  public Iterable<Library> readAll()
	  {
			return libraryRepository.findAll();
	  }
	  public Iterable<Library> getData()
	  {
		  return libraryRepository.findAll();
	  }
	  public Library saveBook(Library book)
	  {
		  return libraryRepository.save(book);
	  }
	  public Iterable<Library> sortBook(String field)
	  {
		  return libraryRepository.findAll(Sort.by(Direction.DESC, field));
		  //return libraryRepository.findAll(Sort.by(field));
	  }
	  public Page<Library>pagingBook(int page,int pageSize)
	  {
		  Pageable paging=PageRequest.of(page, pageSize);
		  return libraryRepository.findAll(paging);
	  }
	  public Page<Library>pagingAndSorting(int pageNo,int pageSize,String field)
	  {
		  Pageable paging=PageRequest.of(pageNo, pageSize).withSort(Sort.by(Direction.DESC, field));
		  return libraryRepository.findAll(paging);
	  }
}
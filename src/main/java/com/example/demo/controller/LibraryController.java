package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Library;
import com.example.demo.service.LibraryService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	//@Autowired 
	//LibraryRepository libraryRepository;
	
	@Operation(summary = "creates a new book details")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "book detail created successfully"),
			@ApiResponse(responseCode="400",description="book detail is invalid")})
	
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<Library> create(final @RequestBody Library library)
	{
		Library createdBook=libraryService.create(library);
		return ResponseEntity.ok(createdBook);
	}
	
	
	@Operation(summary = "get an book detail with an given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "getting book details successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="book detail not found")})
	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<Optional<Library>> read(final @PathVariable int id)
	{
		Optional<Library> readBook=libraryService.read(id);
		return ResponseEntity.ok(readBook);
	}
	
	
	@Operation(summary = "updates an book with an given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "book details updated successfully"),
			@ApiResponse(responseCode="400",description="book details is invalid"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="book detail not found")})
	@PutMapping(value="/{id}",produces="application/json",consumes="application/json")
	public ResponseEntity<Library> updateById(final @RequestBody Library library) throws JsonProcessingException
		{
			final Library updateBook=libraryService.update(library);
			return ResponseEntity.ok(updateBook);
		}
	
	
	@Operation(summary = "Deletes a book detail with an given id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "book detail deleted successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="book detail not found")})
	@DeleteMapping("/{id}")
	public void deleteById(final @PathVariable int id)
	{
		libraryService.delete(id);
	}
	
	@Operation(summary = "get all book detail")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "getting book details successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="book detail not found")})
	@GetMapping(produces="application/json")
	public Iterable<Library> readAll()
	{
		return libraryService.readAll();
	}
	
	
	@GetMapping("/get/{field}")
	  Iterable<Library>bookSort(@PathVariable("field") String field)
	  {
		  return libraryService.sortBook(field);
	  }
	  
	  @GetMapping(value="/paging/{pageNo}/{pageSize}")
	  Page<Library>bookPaging(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize)
	  {
		  return libraryService.pagingBook(pageNo, pageSize);
	  }
	  
	  @GetMapping(value="getps/{pageNo}/{pageSize}/{field}")
	  Page<Library>bookPagingSorting(@PathVariable("pageNo") int pageno,@PathVariable("pageSize") int pageSize,@PathVariable("field") String field)
	  {
		return libraryService.pagingAndSorting(pageno,pageSize,field); 
	  }
}
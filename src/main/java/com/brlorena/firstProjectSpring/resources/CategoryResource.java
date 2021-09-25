package com.brlorena.firstProjectSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brlorena.firstProjectSpring.entitites.Category;
import com.brlorena.firstProjectSpring.repositories.CategoryRepository;

//REST resources and Map of URL, e.g. localhost:8090/categories
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryRepository categoryRepository;
	
	//Anotation GetMapping is to map a response of a GET request 
	@GetMapping // return a list  of Category
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}

	//e.g. localhost:8090/categories/id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}

}

package com.brlorena.firstProjectSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brlorena.firstProjectSpring.entitites.Product;
import com.brlorena.firstProjectSpring.repositories.ProductRepository;

//REST resources and Map of URL, e.g. localhost:8090/categories
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductRepository ProductRepository;
	
	//Anotation GetMapping is to map a response of a GET request 
	@GetMapping // return a list  of Product
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = ProductRepository.findAll();
		
		return ResponseEntity.ok().body(list);
	}

	//e.g. localhost:8090/categories/id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product cat = ProductRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}
	
	
}

package com.brlorena.firstProjectSpring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brlorena.firstProjectSpring.entitites.Category;
import com.brlorena.firstProjectSpring.entitites.Product;
import com.brlorena.firstProjectSpring.repositories.CategoryRepository;
import com.brlorena.firstProjectSpring.repositories.ProductRepository;

@SpringBootApplication
public class FirstProjectSpringApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository catRep;
	
	@Autowired
	private ProductRepository prodRep;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstProjectSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
							
		// id, name, price and category
		Product p1 = new Product(null, "TV", 2200.00, cat1);
		Product p2 = new Product(null, "Domain Driven Design", 120.00, cat2);
		Product p3 = new Product(null, "PS5", 2800.00, cat1);
		Product p4 = new Product(null, "Docker", 100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		
		//Save the Category in data base H2
		catRep.save(cat1);
		catRep.save(cat2);
		
		prodRep.save(p1);
		prodRep.save(p2);
		prodRep.save(p3);
		prodRep.save(p4);
	}

}

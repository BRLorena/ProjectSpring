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
		Category cat1 = new Category(1L, "Electronics");
		Category cat2 = new Category(2L, "Books");
							
		// id, name, price and category
		Product p1 = new Product(1L, "TV", 2200.00, cat1);
		Product p2 = new Product(2L, "Domain Driven Design", 120.00, cat2);
		Product p3 = new Product(3L, "PS5", 2800.00, cat1);
		Product p4 = new Product(4L, "Docker", 100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		
		//Save the Category in Map
		catRep.save(cat1);
		catRep.save(cat2);
		
		prodRep.save(p1);
		prodRep.save(p2);
		prodRep.save(p3);
		prodRep.save(p4);
	}

}

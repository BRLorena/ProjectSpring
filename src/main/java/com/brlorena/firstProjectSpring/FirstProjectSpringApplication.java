package com.brlorena.firstProjectSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brlorena.firstProjectSpring.entitites.Category;
import com.brlorena.firstProjectSpring.repositories.CategoryRepository;

@SpringBootApplication
public class FirstProjectSpringApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository catRep;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstProjectSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(1L, "Electronics");
		Category cat2 = new Category(2L, "Books");
		
		//Save the Category in Map
		catRep.save(cat1);
		catRep.save(cat2);
	}

}

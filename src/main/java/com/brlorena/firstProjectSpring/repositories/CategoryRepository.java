package com.brlorena.firstProjectSpring.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.brlorena.firstProjectSpring.entitites.Category;

@Component
public class CategoryRepository {

	private Map<Long, Category> map = new HashMap<>();
	
	public void save(Category obj) {
		map.put(obj.getId(), obj );
	}

	public Category findById(Long id) {
		return map.get(id);
	}
	
	public List<Category> findAll() {
		// map.values() = search all values of the type Category
		return new ArrayList<Category>(map.values());
	}
}
package com.brlorena.firstProjectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brlorena.firstProjectSpring.entitites.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {


}
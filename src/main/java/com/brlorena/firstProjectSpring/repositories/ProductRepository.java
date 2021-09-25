package com.brlorena.firstProjectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brlorena.firstProjectSpring.entitites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
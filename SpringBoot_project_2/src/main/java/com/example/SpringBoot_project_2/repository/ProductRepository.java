package com.example.SpringBoot_project_2.repository;

import com.example.SpringBoot_project_2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByName(String name);
}

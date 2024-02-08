package com.example.SpringBoot_project_2.service;

import com.example.SpringBoot_project_2.entity.Product;
import com.example.SpringBoot_project_2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public Product saveproduct(Product product){
       return repository.save(product);
    }
    public List<Product> saveproducts(List<Product> products){
        return repository.saveAll(products);
    }
    public List<Product> getproduct(){
        return repository.findAll();
    }
    public Product getproductbyid(int id){
        return repository.findById(id).orElse(null);
    }
    public Product getproductbyname(String name){
        return repository.findByName(name);
    }
    public String deleteproduct(int id){
        repository.deleteById(id);
        return"product deleted"+id;
    }
    public Product updateproduct(Product product){
        Product existingproduct=repository.findById(product.getId()).orElse(null);
        existingproduct.setName(product.getName());
        existingproduct.setPrice(product.getPrice());
        existingproduct.setQuantity(product.getQuantity());
        return repository.save(existingproduct);
    }

}

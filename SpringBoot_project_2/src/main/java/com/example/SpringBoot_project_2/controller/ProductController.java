package com.example.SpringBoot_project_2.controller;

import com.example.SpringBoot_project_2.entity.Product;
import com.example.SpringBoot_project_2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping("/addProduct")
    public Product addproduct(@RequestBody Product product){
        return service.saveproduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addproducts(@RequestBody List<Product> products){
        return service.saveproducts(products);
    }
    @GetMapping("/products")
    public List<Product> findallproduct(){
        return service.getproduct();
    }
    @GetMapping("/productbyid/{id}")
    public Product findproductbyid(@PathVariable int id){
        return service.getproductbyid(id);
    }
    @GetMapping("/product/{name}")
    public Product findproductbyname(@PathVariable String name){
        return service.getproductbyname(name);
    }
    @PutMapping("update")
    public Product updateproduct(@RequestBody Product product){
        return service.updateproduct(product);
    }
    @PostMapping("/delete/{id}")
    public String deleteproduct(@PathVariable int id){
        return service.deleteproduct(id);
    }

}

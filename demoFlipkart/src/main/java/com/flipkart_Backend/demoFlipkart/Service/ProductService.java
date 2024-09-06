package com.flipkart_Backend.demoFlipkart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart_Backend.demoFlipkart.Entity.Product;
import com.flipkart_Backend.demoFlipkart.Repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByIds(List<String> ids) {
        return productRepository.findAllById(ids);
    }
}


//package com.flipkart_Backend.demoFlipkart.Service;
//import com.flipkart_Backend.demoFlipkart.Entity.Product;
//import com.flipkart_Backend.demoFlipkart.Repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ProductRepository productRepository;
//
//    public Product getProductById(String id) {
//        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
//    }
//
//    public List<Product> getProductsByIds(List<String> ids) {
//        return productRepository.findAllById(ids);
//    }
//
//    public Product saveProduct(Product product) {
//        return productRepository.save(product);
//    }
//}



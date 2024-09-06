package com.flipkart_Backend.demoFlipkart.Repository;
import com.flipkart_Backend.demoFlipkart.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
   // List<Product> findAllById(List<String> productIds);
    List<Product> findAllById(List<String> productIds);

}



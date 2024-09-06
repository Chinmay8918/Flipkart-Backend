package com.flipkart_Backend.demoFlipkart.Repository;

//package com.flipkart_Backend.demoFlipkart.Repository;

import com.flipkart_Backend.demoFlipkart.Entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    // Custom query method to find carts by userId
    List<Cart> findByUserId(String userId);

    // You can add more custom query methods if needed
}

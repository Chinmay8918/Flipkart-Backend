package com.flipkart_Backend.demoFlipkart.Entity;

//package com.flipkart_Backend.demoFlipkart.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "carts")
public class Cart {
    @Id
    private String id;
    private String userId; // Reference to the User entity by userId
    private List<String> productIds; // List of Product ids added to the cart

    private double totalPrice; // Store the total price of products in the cart
}


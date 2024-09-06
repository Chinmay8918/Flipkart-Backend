package com.flipkart_Backend.demoFlipkart.Service;

//package com.flipkart_Backend.demoFlipkart.Service;

//import com.flipkart_Backend.demoFlipkart.Entity.Cart;
import com.flipkart_Backend.demoFlipkart.Entity.Cart;
import com.flipkart_Backend.demoFlipkart.Entity.Product;
import com.flipkart_Backend.demoFlipkart.Entity.User;
import com.flipkart_Backend.demoFlipkart.Repository.CartRepository;
import com.flipkart_Backend.demoFlipkart.Repository.ProductRepository;
import com.flipkart_Backend.demoFlipkart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    // Create a new cart for a user
    public Cart createCart(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }

        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setTotalPrice(0.0); // Initialize total price to 0
        return cartRepository.save(cart);
    }

    // Delete a cart by its ID
    public void deleteCart(String cartId) {
        cartRepository.deleteById(cartId);
    }


    public Cart addProductToCart(String cartId, String productId) {
        try {
            Optional<Cart> cartOptional = cartRepository.findById(cartId);
            Optional<Product> productOptional = productRepository.findById(productId);

            if (!cartOptional.isPresent()) {
                throw new RuntimeException("Cart not found");
            }

            if (!productOptional.isPresent()) {
                throw new RuntimeException("Product not found");
            }

            Cart cart = cartOptional.get();
            Product product = productOptional.get();

            // Check if product is already in the cart
            if (!cart.getProductIds().contains(productId)) {
                cart.getProductIds().add(productId);
                cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
                return cartRepository.save(cart);
            }

            // Optionally handle case where product is already in the cart
            return cart;

        } catch (Exception e) {
            // Log the exception and rethrow it
            System.err.println("Error in addProductToCart: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw to propagate to the controller
        }
    }


    // Retrieve a cart by its ID
    public Optional<Cart> getCartById(String cartId) {
        return cartRepository.findById(cartId);
    }
}


// Add a product to the cart
//    public Cart addProductToCart(String cartId, String productId) {
//        Optional<Cart> cartOptional = cartRepository.findById(cartId);
//        Optional<Product> productOptional = productRepository.findById(productId);
//
//        if (!cartOptional.isPresent()) {
//            throw new RuntimeException("Cart not found");
//        }
//
//        if (!productOptional.isPresent()) {
//            throw new RuntimeException("Product not found");
//        }
//
//        Cart cart = cartOptional.get();
//        Product product = productOptional.get();
//
//        // Add product ID to the cart's product list
//        cart.getProductIds().add(product.getId());
//
//        // Update the total price
//        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
//
//        // Save and return the updated cart
//        return cartRepository.save(cart);
//    }


//    public Cart addProductToCart(String cartId, String productId) {
//        Optional<Cart> cartOptional = cartRepository.findById(cartId);
//        Optional<Product> productOptional = productRepository.findById(productId);
//
//        if (!cartOptional.isPresent()) {
//            throw new RuntimeException("Cart not found");
//        }
//
//        if (!productOptional.isPresent()) {
//            throw new RuntimeException("Product not found");
//        }
//
//        Cart cart = cartOptional.get();
//        Product product = productOptional.get();
//
//        // Check if product is already in the cart
//        if (!cart.getProductIds().contains(productId)) {
//            cart.getProductIds().add(productId);
//            cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
//            return cartRepository.save(cart);
//        }
//
//        // Optionally handle case where product is already in the cart
//        return cart;
//    }


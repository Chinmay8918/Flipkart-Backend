package com.flipkart_Backend.demoFlipkart.Controllers;

import com.flipkart_Backend.demoFlipkart.Entity.Product;
import com.flipkart_Backend.demoFlipkart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get product by ID
    @GetMapping("getbyID/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }

    // Get all products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Create a new product
    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Update product by ID
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    // Delete product by ID
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProductById(id);
    }
}





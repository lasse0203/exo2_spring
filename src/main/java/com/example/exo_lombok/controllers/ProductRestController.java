package com.example.exo_lombok.controllers;

import com.example.exo_lombok.Services.ProductService;
import com.example.exo_lombok.exceptions.ResourceNotFoundException;
import com.example.exo_lombok.models.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;
    @GetMapping("list")
    public List<ProductDTO> listProducts(){
        return productService.getProducts();
    }
    @GetMapping("details/{productId}")
    public ResponseEntity<ProductDTO> getProductBy(@PathVariable("productId") UUID id){
        ProductDTO found = productService.getProductBy(id);

        if (found != null) {
            return ResponseEntity.ok(found);
        } else {

            throw new ResourceNotFoundException();
        }
    }
}




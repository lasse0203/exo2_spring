package com.example.exo_lombok.controllers;

import com.example.exo_lombok.Services.ProductService;
import com.example.exo_lombok.exceptions.ResourceNotFoundException;
import com.example.exo_lombok.models.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductController {
private final ProductService productService;

    @RequestMapping(value = "/products/list_products")
    public String list(Model model) {
        List<ProductDTO> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products/list_products";
    }

    @GetMapping("products/{productId}")
    public ResponseEntity<ProductDTO> getProductBy(@PathVariable("productId") UUID id){
        ProductDTO found = productService.getProductBy(id);

        if (found != null) {
            return ResponseEntity.ok(found);
        } else {

            throw new ResourceNotFoundException();
        }
    }

}
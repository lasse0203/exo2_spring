package com.example.exo_lombok.Services;

import com.example.exo_lombok.models.ProductDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class ProductService {

    private final Map<UUID, ProductDTO> products;

    public ProductService() {
        products = new HashMap<>();

        ProductDTO product1 = ProductDTO.builder()
                .id(UUID.randomUUID())
                .productName("samsung")
                .category("Mobile Phone")
                .build();

        ProductDTO product2 = ProductDTO.builder()
                .id(UUID.randomUUID())
                .productName("Iphone14")
                .category("Mobile Phone")
                .build();

        ProductDTO product3 = ProductDTO.builder()
                .id(UUID.randomUUID())
                .productName("Xiaomi Mi12")
                .category("Mobile Phone")
                .build();

        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);

    }

    public List<ProductDTO> getProducts() {
        return products.values().stream().toList();
    }

    public ProductDTO getProductBy(UUID id) {
        return products.values()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
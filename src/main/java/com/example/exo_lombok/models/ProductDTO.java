package com.example.exo_lombok.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class ProductDTO {

    private UUID id ;
    private String productName;
    private String category ;

}

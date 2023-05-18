package com.example.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductRequest {

    private String description;
    private String name;
    private String price;
}

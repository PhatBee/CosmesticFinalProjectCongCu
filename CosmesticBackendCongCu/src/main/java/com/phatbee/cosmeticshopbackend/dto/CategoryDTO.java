package com.phatbee.cosmeticshopbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int categoryId;
    private String categoryName;
    private String imageUrl;
}

package com.cibertec.cibertec_market.domain.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private CategoryDTO category;
}

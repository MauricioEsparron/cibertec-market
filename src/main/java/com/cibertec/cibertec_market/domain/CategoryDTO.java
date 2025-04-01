package com.cibertec.cibertec_market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private int categoryId;
    private String category;
    private boolean active;
}

package com.cibertec.cibertec_market.persistence.mapper;

import com.cibertec.cibertec_market.domain.dto.CategoryDTO;
import com.cibertec.cibertec_market.persistence.model.entity.CategoriaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
        @Mapping(source = "idCategoria", target = "categoryId"),
        @Mapping(source = "descripcion", target = "category"),
        @Mapping(source = "estado", target = "active")
    })
    CategoryDTO toCategory(CategoriaEntity categoria);

    @InheritInverseConfiguration
    // @Mapping(target = "productos", ignore = true)
    CategoriaEntity toCategoria(CategoryDTO category);
}
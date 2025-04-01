package com.cibertec.cibertec_market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.cibertec.cibertec_market.domain.dto.ProductoDTO;
import com.cibertec.cibertec_market.persistence.model.entity.ProductoEntity;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
        @Mapping(source = "idProducto", target = "productId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "categoria", target = "category"), // Mapeo del objeto completo
        @Mapping(source = "idCategoria", target = "categoryId", ignore = false), // Mapeo directo del ID
        @Mapping(source = "precioVenta", target = "price"),
        @Mapping(source = "cantidadStock", target = "stock"),
        @Mapping(source = "estado", target = "active"),
    })
    ProductoDTO toProduct(ProductoEntity producto);
    
    List<ProductoDTO> toProducts(List<ProductoEntity> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarra", ignore = true)
    ProductoEntity toProducto(ProductoDTO product);
}

package com.cibertec.cibertec_market.domain.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.cibertec_market.domain.ProductoDTO;


public interface ProductoService {

    // Método para obtener todos los productos
    List<ProductoDTO> findAllProducts();
    
    // Método para buscar un producto por su ID
    Optional<ProductoDTO> findProductById(int productId);
    
    // Método para obtener productos por categoría (usando categoryId)
    List<ProductoDTO> findByCategory(int categoryId);
    
    // Método para obtener productos con bajo stock (menor cantidad que la proporcionada)
    List<ProductoDTO> findLowStock(int quantity);
    
    // Método para obtener productos escasos (stock bajo)
    List<ProductoDTO> findScarseProducts(int quantity);
    
    // Método para crear un nuevo producto
    ProductoDTO createProduct(ProductoDTO product);
    
    // Método para actualizar un producto
    void updateProduct(int productId, ProductoDTO product);
    
    // Método para eliminar un producto
    void deleteProduct(int productId);
}

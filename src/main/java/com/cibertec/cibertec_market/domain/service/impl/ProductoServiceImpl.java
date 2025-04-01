package com.cibertec.cibertec_market.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.cibertec_market.domain.ProductoDTO;
import com.cibertec.cibertec_market.domain.service.ProductoService;
import com.cibertec.cibertec_market.persistence.mapper.ProductMapper;
import com.cibertec.cibertec_market.persistence.model.entity.ProductoEntity;
import com.cibertec.cibertec_market.persistence.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private final ProductMapper mapper; // Inyectamos el mapper

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> findAllProducts() {
        List<ProductoEntity> productos = productoRepository.findAll();
        return mapper.toProducts(productos); // Mapear de ProductoEntity a Product
    }

    @Override
    public Optional<ProductoDTO> findProductById(int productId) { // Cambiar el tipo del parámetro a 'int'
        return productoRepository.findById(productId)
                .map(producto -> mapper.toProduct(producto)); // Mapear ProductoEntity a Product
    }

    @Override
    public List<ProductoDTO> findByCategory(int categoryId) { // Cambiar el tipo del parámetro a 'int'
        List<ProductoEntity> productos = productoRepository.findByCategoriaIdCategoria(categoryId);
        return mapper.toProducts(productos); // Mapear de ProductoEntity a Product
    }
    @Override
    public List<ProductoDTO> findLowStock(int quantity) {
        List<ProductoEntity> productos = productoRepository.findByCantidadStockLessThan(quantity);
        return mapper.toProducts(productos);
    }
    
    @Override
    public List<ProductoDTO> findScarseProducts(int quantity) {
        List<ProductoEntity> productos = productoRepository.findByCantidadStockLessThanAndEstado(quantity, false);
        return mapper.toProducts(productos);
    }
    
    @Override
    public ProductoDTO createProduct(ProductoDTO product) {
        ProductoEntity producto = mapper.toProducto(product); // Convertir DTO a entidad
        
        producto.setIdProducto(null); // Asegurar que sea una nueva inserción
        
        return mapper.toProduct(productoRepository.save(producto)); // Guardar y mapear a DTO
    }
    

    @Override
    public void updateProduct(int productId, ProductoDTO product) { // Cambiar el tipo del parámetro a 'int'
        ProductoEntity productoEncontrado = productoRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Mapeamos los nuevos valores desde el Product a ProductoEntity
        productoEncontrado.setNombre(product.getName());
        productoEncontrado.setPrecioVenta(product.getPrice());
        productoEncontrado.setCantidadStock(product.getStock());
        productoEncontrado.setEstado(product.isActive());

        productoRepository.save(productoEncontrado);
    }

    @Override
    public void deleteProduct(int productId) { // Cambiar el tipo del parámetro a 'int'
        ProductoEntity productoEncontrado = productoRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoRepository.delete(productoEncontrado);
    }

}

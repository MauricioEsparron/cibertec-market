package com.cibertec.cibertec_market.persistence.repository;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.cibertec_market.persistence.model.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    // Buscar por el ID de la categoría a través de la relación
    List<ProductoEntity> findByCategoriaIdCategoria(int idCategoria);
    List<ProductoEntity> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    List<ProductoEntity> findByCantidadStockLessThan(int cantidadStock);
}

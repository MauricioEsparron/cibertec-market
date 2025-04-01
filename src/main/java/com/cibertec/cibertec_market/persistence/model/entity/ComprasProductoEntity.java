package com.cibertec.cibertec_market.persistence.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "compras_productos")
public class ComprasProductoEntity {
    @EmbeddedId
    private ComprasProductoPK id;
    
    // private Integer idCompra;
    // private Integer idProducto;
    private Integer cantidad;
    private Double total;
    private boolean estado;

    // @ManyToOne
    // @JoinColumn(name = "id_compra")
    // private CompraEntity compra;

    // @ManyToOne
    // @JoinColumn(name = "id_producto")
    // private ProductoEntity producto;


}

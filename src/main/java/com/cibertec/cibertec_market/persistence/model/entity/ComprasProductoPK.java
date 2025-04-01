package com.cibertec.cibertec_market.persistence.model.entity;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ComprasProductoPK implements Serializable{
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;
//     @Override
// public boolean equals(Object o) {
//     if (this == o) return true;
//     if (o == null || getClass() != o.getClass()) return false;
//     ComprasProductoPK that = (ComprasProductoPK) o;
//     return Objects.equals(idCompra, that.idCompra) && 
//            Objects.equals(idProducto, that.idProducto);
// }

// @Override
// public int hashCode() {
//     return Objects.hash(idCompra, idProducto);
// }
}

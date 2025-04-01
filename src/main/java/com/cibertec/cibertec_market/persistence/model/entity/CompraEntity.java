package com.cibertec.cibertec_market.persistence.model.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraEntity {    
    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;
    
    // @Column(name = "id_cliente")
    // private String idCliente;
    
    private String fecha;  

    @Column(name = "medio_pago")
    private String medioPago;
    
    private String comentario;
    
    private String estado;  

	@ManyToOne
	@JoinColumn(name = "id_cliente", insertable = false, updatable = false)
	private ClienteEntity cliente;
}

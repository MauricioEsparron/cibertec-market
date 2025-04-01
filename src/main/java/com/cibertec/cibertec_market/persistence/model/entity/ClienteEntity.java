package com.cibertec.cibertec_market.persistence.model.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {
    @Id
    @Column(name = "id", length = 20, nullable = false)
    private String id;

    private String nombre;
    private String apellido;
    private Long celular;  
    private String direccion;
    
    @Column(name = "correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<CompraEntity> compras;

}

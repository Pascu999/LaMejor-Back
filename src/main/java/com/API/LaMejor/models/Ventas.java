package com.API.LaMejor.models;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Cacheable(false)
public class Ventas {
    @Id
    @SequenceGenerator(name = "venta_generador", sequenceName = "ventas_secuencia", initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "venta_generador")
    @Column(name = "venta_id")
    private Long ventaId;
    @Column(nullable = true ,updatable = false)
    private Date ventaFecha;
    @Column(nullable = true,updatable = true)
    private double ventaTotal;
    @Column(nullable = true,updatable = false,columnDefinition = "integer default 1")
    private int ventaEstado;

    @PrePersist
    public void asignarEstado() {
        this.ventaEstado = 1;

    }
}
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
public class Productos {
    @Id
    @SequenceGenerator(name = "producto_generador", sequenceName = "productos_secuencia", initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "producto_generador")
    @Column(name = "producto_id")
    private Long productoId;
    @Column(nullable = false,updatable = false)
    private String productoNombre;
    @Column(nullable = false,updatable = false)
    private String productoDescripcion;
    @Column(nullable = true,updatable = true)
    private Date productoFechaCreacion;
    @Column(nullable = false,updatable = true)
    private double productoPrecio;
    @Column(nullable = false,updatable = true)
    private int productoExistencias;
    @Column(nullable = true,updatable = true,columnDefinition = "integer default 1")
    private int productoEstado;

    @PrePersist
    public void asignarEstadoYFecha() {
        this.productoFechaCreacion = new Date();
        this.productoEstado = 1;

    }
}


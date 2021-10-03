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
public class Categorias {
    @Id
    @SequenceGenerator(name = "categoria_generador", sequenceName = "categorias_secuencia", initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "categoria_generador")
    @Column(name = "categoria_id", nullable = true, updatable = false)
    private Long categoriaId;
    @Column(nullable = false,updatable = false)
    private String categoriaNombre;
    @Column(nullable = false,updatable = false)
    private String categoriaDescripcion;
    @Column(nullable = true,updatable = false)
    private Date categoriaFechaCreacion;
    @Column(nullable = true,updatable = false,columnDefinition = "integer default 1")
    private int categoriaEstado;


}
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
public class Trabajadores {
    @Id
    @SequenceGenerator(name = "trabajador_generador", sequenceName = "trabajadores_secuencia", initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "trabajadores_generador")
    @Column(name = "trabajador_id", nullable = false, updatable = false)
    private Long trabajadorId;
    @Column(nullable = false,updatable = false)
    private String trabajadorNombre;
    @Column(nullable = false,updatable = false)
    private String trabajadorApellido;
    @Column(nullable = false,updatable = false)
    private String trabajadorCorreo;
    @Column(nullable = false,updatable = false)
    private String trabajadorCelular;
    @Column(nullable = false,updatable = false)
    private String trabajadorDocumento;
    @Column(nullable = false,updatable = true)
    private String trabajadorContrasena;
    @Column(nullable = true,updatable = false,columnDefinition = "integer default 1")
    private int trabajadorEstado;


}
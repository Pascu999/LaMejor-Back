package com.API.LaMejor.controllers;

import com.API.LaMejor.models.VentasContienenProductos;
import com.API.LaMejor.services.VentasContienenProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventasContienenProductos")
public class VentasContienenProductosControlador {

    private final VentasContienenProductosServicio ventasContienenProductosServicio;

    @Autowired
    public VentasContienenProductosControlador(VentasContienenProductosServicio ventasContienenProductosServicio){
        this.ventasContienenProductosServicio = ventasContienenProductosServicio;
    }

    //Crear producto
    @PostMapping("/crear")
    public ResponseEntity<VentasContienenProductos> adicionarProducto(@RequestBody List<VentasContienenProductos> nuevoProducto){
        VentasContienenProductos adicionarVenta = ventasContienenProductosServicio.adicionarProductos(nuevoProducto);
        return new ResponseEntity<>(adicionarVenta,HttpStatus.OK);
    }

    @GetMapping("/obtener/{factura_id}")
    public ResponseEntity<List<VentasContienenProductos>> obtenerDetalleFactura(@PathVariable("factura_id") Long factura_id){
        List<VentasContienenProductos>  listadoDetalles = ventasContienenProductosServicio.obtenerDetalleFactura(factura_id);

        return new ResponseEntity<>(listadoDetalles,HttpStatus.OK);
    }


}

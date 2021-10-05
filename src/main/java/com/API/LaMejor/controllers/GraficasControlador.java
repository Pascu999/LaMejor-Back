package com.API.LaMejor.controllers;

import com.API.LaMejor.proyecciones.MasVendidosProyeccion;
import com.API.LaMejor.proyecciones.MenosVendidosProyeccion;
import com.API.LaMejor.proyecciones.ProductosRenovarProyeccion;
import com.API.LaMejor.proyecciones.VentasMesProyeccion;
import com.API.LaMejor.services.ProductosServicio;
import com.API.LaMejor.services.VentasContienenProductosServicio;
import com.API.LaMejor.services.VentasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graficos")
public class GraficasControlador {

    private final VentasContienenProductosServicio ventasContienenProductosServicio;
    private final VentasServicio ventasServicio;
    private final ProductosServicio productosServicio;

    @Autowired
    public GraficasControlador(VentasContienenProductosServicio ventasContienenProductosServicio, ProductosServicio productosServicio, VentasServicio ventasServicio){
        this.ventasContienenProductosServicio = ventasContienenProductosServicio;
        this.productosServicio = productosServicio;
        this.ventasServicio = ventasServicio;
    }

    @GetMapping("/masVendidos")

    public ResponseEntity<List<MasVendidosProyeccion>> obtenerMasVendidos(){
        List<MasVendidosProyeccion> masVendidos = ventasContienenProductosServicio.obtenerMasVendidos();
        return new ResponseEntity<>(masVendidos, HttpStatus.OK);
    }

    @GetMapping("/menosVendidos")

    public ResponseEntity<List<MenosVendidosProyeccion>> obtenerMenosVendidos(){
        List<MenosVendidosProyeccion> menosVendidos = ventasContienenProductosServicio.obtenerMenosVendidos();
        return new ResponseEntity<>(menosVendidos, HttpStatus.OK);
    }

    @GetMapping("/ventasMes")

    public ResponseEntity<List<VentasMesProyeccion>> obtenerVentasMes(){
        List<VentasMesProyeccion> ventasMes = ventasServicio.obtenerVentasMes();
        return new ResponseEntity<>(ventasMes, HttpStatus.OK);
    }

    @GetMapping("/productosRenovar")

    public ResponseEntity<List<ProductosRenovarProyeccion>> obtenerProductosRenovar(){
        List<ProductosRenovarProyeccion> productosRenovar = productosServicio.obtenerProductosRenovar();
        return new ResponseEntity<>(productosRenovar, HttpStatus.OK);
    }



}
package com.API.LaMejor.services;

import com.API.LaMejor.models.Productos;
import com.API.LaMejor.models.Ventas;
import com.API.LaMejor.models.VentasContienenProductos;
import com.API.LaMejor.models.VentasContienenProductosId;
import com.API.LaMejor.proyecciones.MasVendidosProyeccion;
import com.API.LaMejor.proyecciones.MenosVendidosProyeccion;
import com.API.LaMejor.repositories.VentasContienenProductosRepositorio;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasContienenProductosServicio {

    private final VentasContienenProductosRepositorio ventasContienenProductosRepositorio;

    @Autowired
    public VentasContienenProductosServicio(VentasContienenProductosRepositorio ventasContienenProductosRepositorio){
        this.ventasContienenProductosRepositorio = ventasContienenProductosRepositorio;
    }

    public VentasContienenProductos adicionarProductos(List<VentasContienenProductos> nuevoProducto){
        System.out.println(nuevoProducto);
        ventasContienenProductosRepositorio.saveAll(nuevoProducto);
        return null;
    }

    public List<VentasContienenProductos> obtenerDetalleFactura(Long factura_id){
        return ventasContienenProductosRepositorio.findById_Venta(factura_id);
    }

    public List<MasVendidosProyeccion> obtenerMasVendidos(){
        return ventasContienenProductosRepositorio.obtenerMasVendidos();
    }

    public List<MenosVendidosProyeccion> obtenerMenosVendidos(){
        return ventasContienenProductosRepositorio.obtenerMenosVendidos();
    }



}

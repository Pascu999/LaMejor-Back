package com.API.LaMejor.services;

import com.API.LaMejor.models.Ventas;
import com.API.LaMejor.proyecciones.MenosVendidosProyeccion;
import com.API.LaMejor.proyecciones.VentasMesProyeccion;
import com.API.LaMejor.repositories.VentasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServicio {

    private final VentasRepositorio ventasRepositorio;

    @Autowired
    public VentasServicio(VentasRepositorio ventasRepositorio){
        this.ventasRepositorio = ventasRepositorio;
    }

    public Ventas crearVenta(Ventas nuevaVenta){
        return ventasRepositorio.save(nuevaVenta);
    }

    public List<Ventas> listarVentas(){
        return ventasRepositorio.findAll();
    }

    public List<VentasMesProyeccion> obtenerVentasMes(){
        return ventasRepositorio.obtenerVentasMes();
    }

}

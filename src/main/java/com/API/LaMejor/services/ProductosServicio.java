package com.API.LaMejor.services;

import com.API.LaMejor.models.Productos;
import com.API.LaMejor.proyecciones.ProductosRenovarProyeccion;
import com.API.LaMejor.repositories.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServicio {

    private final ProductosRepositorio productosRepositorio;

    @Autowired
    public ProductosServicio(ProductosRepositorio productosRepositorio){
        this.productosRepositorio = productosRepositorio;
    }

    public Productos crearProducto(Productos nuevoProducto){
        return productosRepositorio.save(nuevoProducto);
    }

    public List<Productos> listarProductos(){
        return productosRepositorio.findProductosByProductoEstado();
    }

    public Productos editarProducto(Productos productoEditar) {
        Productos productoEditado = productosRepositorio.save(productoEditar);

        return productoEditado;
    }

    public List<ProductosRenovarProyeccion> obtenerProductosRenovar( ) {
        return productosRepositorio.obtenerProductosRenovar();
    }
}

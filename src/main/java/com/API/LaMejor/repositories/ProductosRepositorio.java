package com.API.LaMejor.repositories;

import com.API.LaMejor.models.Productos;
import com.API.LaMejor.proyecciones.MenosVendidosProyeccion;
import com.API.LaMejor.proyecciones.ProductosRenovarProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductosRepositorio extends JpaRepository<Productos,Long> {

    @Transactional(readOnly = true)
    @Query("FROM Productos p WHERE p.productoEstado = 1")
    public List<Productos> findProductosByProductoEstado();

    @Transactional(readOnly = true)
    @Query(nativeQuery = true,value = "SELECT * FROM v_renovar_productos")
    public List<ProductosRenovarProyeccion> obtenerProductosRenovar();


}

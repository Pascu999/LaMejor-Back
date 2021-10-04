package com.API.LaMejor.repositories;

import com.API.LaMejor.models.Ventas;
import com.API.LaMejor.proyecciones.VentasMesProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VentasRepositorio extends JpaRepository<Ventas,Long>{
    @Transactional(readOnly = true)
    @Query(nativeQuery = true,value = "SELECT * FROM v_ventas_mes")
    public List<VentasMesProyeccion> obtenerVentasMes();


}

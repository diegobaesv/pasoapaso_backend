package com.sise.pasoapaso_backend.proyecto.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer> {
    List<Proyecto> findByEstadoAuditoria(String estadoAuditoria);
    List<Proyecto> findByTituloAndDescripcion(String titulo, String descripcion);

    @Modifying
    @Query("UPDATE Proyecto p SET p.estadoAuditoria = '0' WHERE p.idProyecto = :idProyecto")
    void darBajaProyecto(@Param("idProyecto") Integer idProyecto);
}



// supongamos que estamos en usuarios , y el campo correo es unique, y queremos obtener el usuario por el correo

// Usuario findOneByCorreo(String correo);

/*

ESTO ES JPQL
@Query("Select u from Usuario u where u.rol.descripcion <> 'ADMIN' ")

 */
package com.sise.pasoapaso_backend.proyecto.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer> {
    
}

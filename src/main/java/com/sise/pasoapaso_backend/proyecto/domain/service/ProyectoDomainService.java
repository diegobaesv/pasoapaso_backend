package com.sise.pasoapaso_backend.proyecto.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.pasoapaso_backend.common.domain.enums.EstadoAuditoria;
import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;
import com.sise.pasoapaso_backend.proyecto.domain.repository.ProyectoRepository;

@Service
public class ProyectoDomainService {

    @Autowired
    ProyectoRepository proyectoRepository;

    public Proyecto insertarProyecto(Proyecto proyecto) {
        Proyecto newProyecto = proyectoRepository.save(proyecto);
        return proyectoRepository.findById(newProyecto.getIdProyecto()).orElse(null);
    }

    public List<Proyecto> listarProyectos() {
        return proyectoRepository.findByEstadoAuditoria(EstadoAuditoria.ACTIVO);
    }

    public void darBajaProyecto(Integer idProyecto) {
        //forma 1
        // Proyecto proyecto = proyectoRepository.findById(idProyecto).orElse(null);
        // if(proyecto != null) {
        //     proyecto.setEstadoAuditoria(EstadoAuditoria.INACTIVO);
        //     proyectoRepository.save(proyecto);
        // }

        //forma 2
        proyectoRepository.darBajaProyecto(idProyecto);
    }
    
}

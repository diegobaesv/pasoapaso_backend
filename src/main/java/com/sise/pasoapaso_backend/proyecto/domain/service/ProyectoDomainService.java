package com.sise.pasoapaso_backend.proyecto.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return proyectoRepository.findAll();
    }
    
}

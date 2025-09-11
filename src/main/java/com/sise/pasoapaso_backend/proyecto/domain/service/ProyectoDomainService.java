package com.sise.pasoapaso_backend.proyecto.domain.service;

import org.springframework.stereotype.Service;

import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;

@Service
public class ProyectoDomainService {

    public Proyecto insertarProyecto(Proyecto proyecto) {
        proyecto.setIdProyecto(1);
        return proyecto;
    }
    
}

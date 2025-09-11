package com.sise.pasoapaso_backend.proyecto.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.pasoapaso_backend.proyecto.application.dto.request.InsertarProyectoRequestDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.InsertarProyectoResponseDto;
import com.sise.pasoapaso_backend.proyecto.application.mapper.InsertarProyectoMapper;
import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;
import com.sise.pasoapaso_backend.proyecto.domain.service.ProyectoDomainService;

@Service
public class ProyectoApplicationService {

    @Autowired
    ProyectoDomainService proyectoDomainService;

    @Autowired
    InsertarProyectoMapper insertarProyectoMapper;
    
    public InsertarProyectoResponseDto insertarProyecto(InsertarProyectoRequestDto requestDto) {
        Proyecto proyecto = proyectoDomainService.insertarProyecto(insertarProyectoMapper.requestToEntity(requestDto));
        return insertarProyectoMapper.entityToResponse(proyecto);
    }

}

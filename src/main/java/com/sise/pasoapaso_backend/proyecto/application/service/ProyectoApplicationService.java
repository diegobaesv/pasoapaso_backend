package com.sise.pasoapaso_backend.proyecto.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.pasoapaso_backend.proyecto.application.dto.request.InsertarProyectoRequestDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.InsertarProyectoResponseDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.ListarProyectoResponseDto;
import com.sise.pasoapaso_backend.proyecto.application.mapper.InsertarProyectoMapper;
import com.sise.pasoapaso_backend.proyecto.application.mapper.ListarProyectoMapper;
import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;
import com.sise.pasoapaso_backend.proyecto.domain.service.ProyectoDomainService;

@Service
public class ProyectoApplicationService {

    @Autowired
    ProyectoDomainService proyectoDomainService;

    @Autowired
    InsertarProyectoMapper insertarProyectoMapper;

    @Autowired
    ListarProyectoMapper listarProyectoMapper;
    
    public InsertarProyectoResponseDto insertarProyecto(InsertarProyectoRequestDto requestDto) {
        Proyecto proyecto = proyectoDomainService.insertarProyecto(insertarProyectoMapper.requestToEntity(requestDto));
        return insertarProyectoMapper.entityToResponse(proyecto);
    }

    public List<ListarProyectoResponseDto> listarProyectos() {
        List<Proyecto> proyectos = proyectoDomainService.listarProyectos();

        // Forma tradicional
        // List<ListarProyectoResponseDto> responseDtos = new ArrayList<>();
        // for (Proyecto proyecto : proyectos) {
        //     responseDtos.add(listarProyectoMapper.entityToResponse(proyecto));
        // }
        // return responseDtos;

        // Forma con streams
        return proyectos.stream()
            .map(listarProyectoMapper::entityToResponse)
            //.map(proyecto -> listarProyectoMapper.entityToResponse(proyecto))
            .toList();
    }

}

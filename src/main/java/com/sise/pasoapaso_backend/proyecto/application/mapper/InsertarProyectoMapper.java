package com.sise.pasoapaso_backend.proyecto.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.pasoapaso_backend.common.application.IEntityDtoMapper;
import com.sise.pasoapaso_backend.proyecto.application.dto.request.InsertarProyectoRequestDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.InsertarProyectoResponseDto;
import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;

@Component
public class InsertarProyectoMapper implements IEntityDtoMapper<Proyecto,InsertarProyectoRequestDto,InsertarProyectoResponseDto> {

    @Override
    public Proyecto requestToEntity(InsertarProyectoRequestDto requestDto) {
        Proyecto proyecto = new Proyecto();
        proyecto.setTitulo(requestDto.getTitulo());
        proyecto.setDescripcion(requestDto.getDescripcion());
        return proyecto;
    }

    @Override
    public InsertarProyectoResponseDto entityToResponse(Proyecto entity) {
        InsertarProyectoResponseDto responseDto = new InsertarProyectoResponseDto();
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setTitulo(entity.getTitulo());
        responseDto.setIdProyecto(entity.getIdProyecto());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
    

}

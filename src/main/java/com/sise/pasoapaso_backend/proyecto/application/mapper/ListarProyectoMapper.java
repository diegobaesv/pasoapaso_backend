package com.sise.pasoapaso_backend.proyecto.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.pasoapaso_backend.common.application.IEntityDtoMapper;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.ListarProyectoResponseDto;
import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;

@Component
public class ListarProyectoMapper implements IEntityDtoMapper<Proyecto,ListarProyectoResponseDto,ListarProyectoResponseDto> {

    @Override
    public Proyecto requestToEntity(ListarProyectoResponseDto requestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestToEntity'");
    }

    @Override
    public ListarProyectoResponseDto entityToResponse(Proyecto entity) {
        if (entity == null) {
            return null;
        }
        ListarProyectoResponseDto responseDto = new ListarProyectoResponseDto();
        responseDto.setIdProyecto(entity.getIdProyecto());
        responseDto.setTitulo(entity.getTitulo());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
    
}

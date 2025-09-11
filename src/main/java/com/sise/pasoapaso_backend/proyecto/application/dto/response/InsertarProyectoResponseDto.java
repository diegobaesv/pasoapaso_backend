package com.sise.pasoapaso_backend.proyecto.application.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class InsertarProyectoResponseDto {
    private Integer idProyecto;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}

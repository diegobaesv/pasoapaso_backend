package com.sise.pasoapaso_backend.proyecto.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InsertarProyectoRequestDto {

    @NotBlank
    @Size(min = 1, max = 150)
    private String titulo;

    @NotBlank
    @Size(min = 1, max = 500)
    private String descripcion;
}

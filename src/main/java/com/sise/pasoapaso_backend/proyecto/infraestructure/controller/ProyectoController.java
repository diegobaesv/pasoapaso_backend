package com.sise.pasoapaso_backend.proyecto.infraestructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sise.pasoapaso_backend.proyecto.application.dto.request.InsertarProyectoRequestDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.InsertarProyectoResponseDto;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @PostMapping("")
    public ResponseEntity<InsertarProyectoResponseDto> insertarProyecto(
        @RequestBody InsertarProyectoRequestDto request
    ) {
        try {
            return ResponseEntity.ok(new InsertarProyectoResponseDto());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

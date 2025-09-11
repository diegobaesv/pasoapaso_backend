package com.sise.pasoapaso_backend.proyecto.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sise.pasoapaso_backend.proyecto.application.dto.request.InsertarProyectoRequestDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.InsertarProyectoResponseDto;
import com.sise.pasoapaso_backend.proyecto.application.service.ProyectoApplicationService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoApplicationService proyectoApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarProyectoResponseDto> insertarProyecto(
        @RequestBody InsertarProyectoRequestDto requestDto
    ) {
        try {
            InsertarProyectoResponseDto responseDto = proyectoApplicationService.insertarProyecto(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

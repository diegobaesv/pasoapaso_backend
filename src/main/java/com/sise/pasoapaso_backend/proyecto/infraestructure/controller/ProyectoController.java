package com.sise.pasoapaso_backend.proyecto.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.pasoapaso_backend.common.application.dto.response.BaseResponseDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.request.InsertarProyectoRequestDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.InsertarProyectoResponseDto;
import com.sise.pasoapaso_backend.proyecto.application.dto.response.ListarProyectoResponseDto;
import com.sise.pasoapaso_backend.proyecto.application.service.ProyectoApplicationService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoApplicationService proyectoApplicationService;

    @PostMapping("")
    public ResponseEntity<BaseResponseDto> insertarProyecto(
        @Valid @RequestBody InsertarProyectoRequestDto requestDto
    ) {
        try {
            InsertarProyectoResponseDto responseDto = proyectoApplicationService.insertarProyecto(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto> listarProyectos() {
        try {
            List<ListarProyectoResponseDto> responseDto = proyectoApplicationService.listarProyectos();
            return ResponseEntity.ok(BaseResponseDto.success(responseDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(BaseResponseDto.error(e.getMessage()));
        }
    }
    

}

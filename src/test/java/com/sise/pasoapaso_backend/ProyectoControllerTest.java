package com.sise.pasoapaso_backend;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sise.pasoapaso_backend.proyecto.domain.entities.Proyecto;
import com.sise.pasoapaso_backend.proyecto.domain.repository.ProyectoRepository;
import com.sise.pasoapaso_backend.proyecto.infraestructure.controller.ProyectoController;

@SpringBootTest
@AutoConfigureMockMvc
public class ProyectoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProyectoRepository proyectoRepository;

    @Test
    void deberiaListarProyectos() throws Exception {
        System.out.println("Ejecutnado prueba unitaria deberiaListarProyectos");

        List<Proyecto> proyectos = new ArrayList();

        Proyecto p1 = new Proyecto();
        p1.setIdProyecto(1);
        p1.setTitulo("Proyecto SISE");
        p1.setDescripcion("Nueva App");
        p1.setFechaCreacion(LocalDateTime.parse("2025-09-11T22:18:02.00055"));

        proyectos.add(p1);

        when(proyectoRepository.findByEstadoAuditoria("1")).thenReturn(proyectos);

        mockMvc.perform(get("/proyectos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.success").value(true))
            .andExpect(jsonPath("$.message").value("Ok"))
            .andExpect(jsonPath("$.data[0].idProyecto").value(1))
            .andExpect(jsonPath("$.data[0].titulo").value("Proyecto SISE"))
            .andExpect(jsonPath("$.data[0].descripcion").value("Nueva App"))
            .andExpect(jsonPath("$.data[0].fechaCreacion").value("2025-09-11T22:18:02.00055"))
            .andExpect(jsonPath("$.errors").doesNotExist())
            ;
    }
    
}

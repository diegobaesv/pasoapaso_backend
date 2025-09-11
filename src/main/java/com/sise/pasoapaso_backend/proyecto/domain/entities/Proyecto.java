package com.sise.pasoapaso_backend.proyecto.domain.entities;

import java.time.LocalDateTime;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import lombok.Data;

@Data
// @Entity
// @Table(name = "proyectos")
public class Proyecto {

    // @Id
    // @Column(name = "id_proyecto")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProyecto;

    // @Column(name = "titulo")
    private String titulo;

    // @Column(name = "descripcion")
    private String descripcion;

    // @Column(name = "estado_auditoria", insertable = false, updatable = false)
    private String estadoAuditoria;

    // @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;
    
}

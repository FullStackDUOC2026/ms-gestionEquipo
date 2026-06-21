package com.example.ms_asignaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="asignacion")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long idEmpleado;
    @Column(nullable = false)
    private Long idEquipo;
    @Column(nullable = false)
    private String accion;
    @Builder.Default
    @Column(nullable = false)
    private Boolean activo = true;
    @Column(nullable = false)
    private LocalDate fecha;
}

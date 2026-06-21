package com.example.ms_asignaciones.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsignacionRequestDTO {

    private Long idEmpleado;
    private Long idEquipo;

}

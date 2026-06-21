package com.example.ms_asignaciones.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsignacionRequestDTO {

    @NotNull
    private Long idEmpleado;
    @NotNull
    private Long idEquipo;

}

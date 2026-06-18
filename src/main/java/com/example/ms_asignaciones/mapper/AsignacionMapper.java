package com.example.ms_asignaciones.mapper;

import com.example.ms_asignaciones.dto.request.AsignacionRequestDTO;
import com.example.ms_asignaciones.dto.response.AsignacionResponseDTO;
import com.example.ms_asignaciones.model.Asignacion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsignacionMapper {

        Asignacion toAsignacion(AsignacionRequestDTO request);
        AsignacionResponseDTO toAsignacionResponseDTO (Asignacion asignacion);
        List<AsignacionResponseDTO> toListAsignacionResponseDTO (List<Asignacion> listaAsignaciones);
}

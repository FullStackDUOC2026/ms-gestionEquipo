package com.example.ms_asignaciones.service;

import com.example.ms_asignaciones.config.WebClientConfig;
import com.example.ms_asignaciones.dto.request.AsignacionRequestDTO;
import com.example.ms_asignaciones.dto.response.AsignacionResponseDTO;
import com.example.ms_asignaciones.dto.response.EmpleadoResponseDTO;
import com.example.ms_asignaciones.dto.response.EquipoResponseDTO;
import com.example.ms_asignaciones.mapper.AsignacionMapper;
import com.example.ms_asignaciones.model.Asignacion;
import com.example.ms_asignaciones.repository.AsignacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsignacionService {
    private final AsignacionRepository asignacionRepository;
    private final AsignacionMapper mapper;
    private final WebClientConfig webClient;

    public void comprobarEmplelado(Long id){
        webClient.webClientEmpleado()
                .get()
                .uri("/{id}")
                .retrieve()
                .bodyToMono(EmpleadoResponseDTO.class)
                .block();

    }
    public void comprobarEquipo(Long id){
        webClient.webClientEquipo()
                .get()
                .uri("/{id}")
                .retrieve()
                .bodyToMono(EquipoResponseDTO.class)
                .block();
    }

    public Asignacion localBuscarPorId(Long id){
        return asignacionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("La asignacion no existe"));
    }





}

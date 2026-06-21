package com.example.ms_asignaciones.service;

import com.example.ms_asignaciones.dto.request.AsignacionRequestDTO;
import com.example.ms_asignaciones.dto.response.AsignacionResponseDTO;
import com.example.ms_asignaciones.exception.AsignacionNotFoundException;
import com.example.ms_asignaciones.mapper.AsignacionMapper;
import com.example.ms_asignaciones.model.Asignacion;
import com.example.ms_asignaciones.repository.AsignacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionService {
    private final AsignacionRepository asignacionRepository;
    private final AsignacionMapper mapper;
    private final WebClient webClientEmpleado;
    private final WebClient webClientEquipo;


    //================================= COMPROBACIONES =================================

    public void comprobarEmpleado(Long id) {
        webClientEmpleado
                .get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

    }

    public void comprobarEquipo(Long id) {
        webClientEquipo
                .get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public Asignacion localBuscarAsignacionPorId(Long id) {
        return asignacionRepository.findById(id)
                .orElseThrow(() -> new AsignacionNotFoundException(id));
    }

    //================================= METODOS =================================

    public AsignacionResponseDTO asignarEquipoToEmpleado(AsignacionRequestDTO requestDTO) {


        comprobarEmpleado(requestDTO.getIdEmpleado());
        comprobarEquipo(requestDTO.getIdEquipo());


        Asignacion varAsignacion = Asignacion.builder()
                .idEmpleado(requestDTO.getIdEmpleado())
                .idEquipo(requestDTO.getIdEquipo())
                .accion("Asignado a empleado: " + requestDTO.getIdEmpleado())
                .fecha(LocalDate.now())
                .build();

        return mapper.toAsignacionResponseDTO(asignacionRepository.save(varAsignacion));
    }

    public List<AsignacionResponseDTO> listarAsignaciones() {
        return mapper.toListAsignacionResponseDTO(asignacionRepository.findAll());
    }

    public List<AsignacionResponseDTO> asignacionesDeEmpleadoActivas(Long idEmpleado) {
        List<AsignacionResponseDTO> ListTodas = listarAsignaciones();
        List<AsignacionResponseDTO> ListaAsignacionesDeUsuario = new ArrayList<>();
        for (AsignacionResponseDTO responseDTO : ListTodas) {
            if (responseDTO.getIdEmpleado().equals(idEmpleado) && (responseDTO.getActivo())) {
                ListaAsignacionesDeUsuario.add(responseDTO);
            }
        }
        return ListaAsignacionesDeUsuario;
    }

    public AsignacionResponseDTO quitarAsignacionToEmpleado(Long idAsignacion) {
        Asignacion varAsignacion = localBuscarAsignacionPorId(idAsignacion);
        varAsignacion.setActivo(false);
        return mapper.toAsignacionResponseDTO(asignacionRepository.save(varAsignacion));
    }









}

package com.example.ms_asignaciones.service;

import com.example.ms_asignaciones.config.WebClientConfig;
import com.example.ms_asignaciones.dto.response.AsignacionResponseDTO;
import com.example.ms_asignaciones.dto.response.EmpleadoResponseDTO;
import com.example.ms_asignaciones.dto.response.EquipoResponseDTO;
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
    private final  WebClient webClientEmpleado;
    private final WebClient webClientEquipo;

    //================================= COMPROBACIONES =================================

    public void comprobarEmpleado(Long id){
        webClientEmpleado
                .get()
                .uri("/{id}",id)
                .retrieve()
                .bodyToMono(EmpleadoResponseDTO.class)
                .block();

    }
    public void comprobarEquipo(Long id){
        webClientEquipo
                .get()
                .uri("/{id}",id)
                .retrieve()
                .bodyToMono(EquipoResponseDTO.class)
                .block();
    }

    public Asignacion localBuscarAsignacionPorId(Long id){
        return asignacionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("La asignacion no existe"));
    }

    //================================= METODOS =================================

    public AsignacionResponseDTO asignarEquipoToEmpleado(Long idEquipo, Long idEmpleado){
        comprobarEmpleado(idEmpleado);
        comprobarEquipo(idEquipo);

        Asignacion varAsignacion = Asignacion.builder()
                .idEmpleado(idEmpleado)
                .idEquipo(idEquipo)
                .accion("Asignado a empleado: "+idEmpleado)
                .fecha(LocalDate.now())
                .build();

        return mapper.toAsignacionResponseDTO(asignacionRepository.save(varAsignacion));
    }

    public List<AsignacionResponseDTO> listarAsignaciones(){
        return mapper.toListAsignacionResponseDTO(asignacionRepository.findAll());
    }

    public List<AsignacionResponseDTO> AsignacionesDeEmpleadoActivas (Long idEmpleado){
        List<AsignacionResponseDTO> ListTodas = listarAsignaciones();
        List<AsignacionResponseDTO> ListaAsignacionesDeUsuario = new ArrayList<>();
        for (AsignacionResponseDTO responseDTO : ListTodas){
            if (responseDTO.getIdEmpleado().equals(idEmpleado) && (responseDTO.getActivo() == true)){
                ListaAsignacionesDeUsuario.add(responseDTO);
            }
        }
        return ListaAsignacionesDeUsuario;
    }
    public AsignacionResponseDTO  quitarAsignacionToEmplado (Long idAsignacion){
        Asignacion varAsignacion = localBuscarAsignacionPorId(idAsignacion);
        varAsignacion.setActivo(false);
        return mapper.toAsignacionResponseDTO(asignacionRepository.save(varAsignacion));
    }








}

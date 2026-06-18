package com.example.ms_asignaciones.controller;

import com.example.ms_asignaciones.dto.response.AsignacionResponseDTO;
import com.example.ms_asignaciones.service.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/asignacion")
@RequiredArgsConstructor
public class AsignacionController {
    private final AsignacionService asignacionService;

    @PostMapping("/{idEquipo}/{idEmpleado}")
    public ResponseEntity<AsignacionResponseDTO> asignarEquipoToEmpleado (@PathVariable Long idEquipo,@PathVariable Long idEmpleado){
        return ResponseEntity.status(CREATED).body(asignacionService.asignarEquipoToEmpleado(idEquipo,idEmpleado));
    }
    @GetMapping
    public ResponseEntity<List<AsignacionResponseDTO>> listarAsignaciones(){
        return ResponseEntity.ok(asignacionService.listarAsignaciones());
    }
}

package com.example.ms_asignaciones.exception;


public class AsignacionNotFoundException extends RuntimeException {

    public AsignacionNotFoundException(Long id){
        super("Asignacion no encontrada "+id);
    }
}

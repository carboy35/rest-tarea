package com.soaint.service;

import org.springframework.http.ResponseEntity;

import com.soaint.model.Response;
import com.soaint.model.Tarea;

public interface TareaService {
	public ResponseEntity<Response> listarTareas();
	public ResponseEntity<Response> insertarTarea(Tarea tarea);
	public ResponseEntity<Response> eliminarTarea(Integer idTarea);
	public ResponseEntity<Response> actualizarTarea(Tarea tarea);
}

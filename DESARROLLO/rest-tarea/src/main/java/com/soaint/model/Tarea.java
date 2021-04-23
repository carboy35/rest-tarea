package com.soaint.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class Tarea {
	@Valid
	@NotNull(message="{mensaje.requerido}")
	private Integer idTarea;
	@Valid
	@NotNull(message="{mensaje.requerido}")
	private String descripcion;
	@Valid
	@NotNull(message="{mensaje.requerido}")
	private Date fechaCreacion;
	@Valid
	@NotNull(message="{mensaje.requerido}")
	private boolean vigente;

}

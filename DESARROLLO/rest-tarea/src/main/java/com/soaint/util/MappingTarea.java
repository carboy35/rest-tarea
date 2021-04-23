package com.soaint.util;

import org.springframework.stereotype.Service;

import com.soaint.entities.TarTarea;
import com.soaint.model.Tarea;

@Service
public class MappingTarea {


	public Tarea entityToModel(TarTarea tareaEntity) {
		Tarea tarea=new Tarea();
		tarea.setIdTarea(tareaEntity.getTarId());
		tarea.setDescripcion(tareaEntity.getTarDescripcion());
		tarea.setFechaCreacion(tareaEntity.getTarFechaCreacion());
		tarea.setVigente((Boolean)tareaEntity.getVigente());
		return tarea;
	}
	
	public TarTarea modelToEntity(Tarea tarea) {
		TarTarea tareaEntity=new TarTarea();
		tareaEntity.setTarId(tarea.getIdTarea());
		tareaEntity.setTarDescripcion(tarea.getDescripcion());
		tareaEntity.setTarFechaCreacion(tarea.getFechaCreacion());
		tareaEntity.setVigente((Boolean)tarea.isVigente());
		return tareaEntity;
	}

}

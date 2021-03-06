package com.cursospring.modelo.negocio.basico;

import org.springframework.stereotype.Component;

import com.cursospring.modelo.entidades.Usuario;
import com.cursospring.modelo.negocio.Constantes;
import com.cursospring.modelo.negocio.ReglasAfines;

@Component
public class BasicasReglasAfines implements ReglasAfines {

	/* (non-Javadoc)
	 * @see com.cursospring.modelo.negocio.ReglasAfines#sonAfines(com.cursospring.modelo.entidades.Usuario, com.cursospring.modelo.entidades.Usuario)
	 */
	public boolean sonAfines(Usuario elQueBusca, Usuario candidato) {
		return !elQueBusca.equals(candidato) 
				&& Math.abs(elQueBusca.getAltura() - candidato.getAltura()) < 0.50 
				&& Math.abs(elQueBusca.getFechaNacimiento().getTime() - candidato.getFechaNacimiento().getTime()) < (10*Constantes.MILISEGUNDOS_POR_A�O);
	}

}

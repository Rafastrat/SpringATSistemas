package com.cursospring.modelo.negocio.basico;

import org.springframework.stereotype.Component;

import com.cursospring.modelo.entidades.Usuario;
import com.cursospring.modelo.negocio.Constantes;
import com.cursospring.modelo.negocio.ReglasIdeal;

@Component
public class BasicasReglasIdeal implements ReglasIdeal {

	/* (non-Javadoc)
	 * @see com.cursospring.modelo.negocio.ReglasIdeal#sonIdeales(com.cursospring.modelo.entidades.Usuario, com.cursospring.modelo.entidades.Usuario)
	 */
	public boolean sonIdeales(Usuario elQueBusca, Usuario candidato) {
		return !elQueBusca.equals(candidato) 
				&& !elQueBusca.getGenero().equals(candidato.getGenero())
				&& Math.abs(elQueBusca.getAltura() - candidato.getAltura()) < 0.10 
				&& Math.abs(elQueBusca.getFechaNacimiento().getTime() - candidato.getFechaNacimiento().getTime()) < (5*Constantes.MILISEGUNDOS_POR_A�O);
	}

}

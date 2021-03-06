package com.cursospring.modelo.negocio;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cursospring.modelo.entidades.Usuario;
import com.cursospring.modelo.persistencia.UsuarioDao;

@Component
public class PortalParejasNegocioImpl implements PortalParejasNegocio {

	@Autowired
	private UsuarioDao dao;
	
	@Autowired
	private ReglasAfines reglasAfines;
	
	@Autowired
	private ReglasIdeal reglasIdeal;
	
	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	public Usuario buscarIdeal(Usuario elQueBusca) {
		List<Usuario> candidatos = dao.findAll();
		for (Usuario candidato : candidatos) {
			if(reglasIdeal.sonIdeales(elQueBusca, candidato)){
				return candidato;
			}
		}
		return null;
	}

	public List<Usuario> buscarUsuariosAfinesAUsuario(Usuario elQueBusca) {
		List<Usuario> candidatos = dao.findAll();
		List<Usuario> afines = new LinkedList<Usuario>();
		for (Usuario candidato : candidatos) {
			if(reglasAfines.sonAfines(elQueBusca, candidato)){
				afines.add(candidato);
			}
		}
		return afines;
	}
}

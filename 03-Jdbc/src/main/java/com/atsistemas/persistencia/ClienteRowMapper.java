package com.atsistemas.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.atsistemas.entidades.Cliente;

public class ClienteRowMapper implements RowMapper<Cliente> {

	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Cliente(
				rs.getInt("id"),
				rs.getString("nombre"));
	}

}

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Factory.conexionDB_alura;

public class Usuarios {

	private String nombre;
	private String apellido;
	
	public Usuarios(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public static boolean validarUsuario(String nombre, String apellido) {
		conexionDB_alura con = new conexionDB_alura();
		Connection conex = null;
		PreparedStatement preState = null;
		ResultSet resulset = null;
		
		try {
			conex = con.ConectarConexion();
			preState = conex.prepareStatement("SELECT * FROM hotel_alura_one_orecle.usuarios WHERE nombre = ? and contraseña = ?");
			preState.setString(1, nombre);
			preState.setString(2, apellido);
			resulset = preState.executeQuery();
			return resulset.next();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(resulset != null) resulset.close();
				if(preState != null) resulset.close();	
				if(conex != null) resulset.close();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}
	}
}

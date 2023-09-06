package Controller;

import java.sql.Connection;
import java.util.List;

import Factory.conexionDB_alura;
import funcionDAO.HuespedesDAO;

import modelo.Huespedes;


public class HuespedesController {



private HuespedesDAO huespedesDAO;
	
	public HuespedesController() {
		super();
		
		Connection con = new conexionDB_alura().ConectarConexion();
		this.huespedesDAO = new HuespedesDAO(con);
		
	}
	
	
	public void guardar(Huespedes huespedes) {
		
		this.huespedesDAO.guardar(huespedes);
		
	}
	
public List<Huespedes>  listar() {
		
		
		return  huespedesDAO.listar(); 
		
	}
}

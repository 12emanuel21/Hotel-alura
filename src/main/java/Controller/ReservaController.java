package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Factory.conexionDB_alura;
import funcionDAO.ReservaDAO;
import modelo.Reserva;


public class ReservaController {
private ReservaDAO reservaDAO;
	


	public ReservaController() {
		super();
		
		Connection con = new conexionDB_alura().ConectarConexion();
		this.reservaDAO = new ReservaDAO(con);
		
	}
	
	
	public void guardar(Reserva reserva) {
		
		this.reservaDAO.guardar(reserva);
		
	}
	
	public void mostrarReserva(Reserva reserva) {
		
		//this.reservaDAO.mostrarReserva(reserva);
		
	}
public List<Reserva>  listar() {
		
		
		return  reservaDAO.listar(); 
		
	}



public int modificar(String fechaEntrada, String fechaSalida, String valor, String formadePago, Integer id) throws SQLException{
	conexionDB_alura factory = new conexionDB_alura();
	
	final Connection con = factory.ConectarConexion();	
	try (con){
		
		final PreparedStatement preper = con.prepareStatement(" UPDATE hotel_alura_challenge_one.reservasgood SET" +
				"FechaEntrada =?"+
				"FechaSalida=?"+"Valor=?"+"FormadePago=?"+
				"where id = ?");
		try(preper){
			preper.setString(1,fechaEntrada);
			preper.setString(2,fechaSalida);
			preper.setString(3,valor);
			preper.setString(4,formadePago);
			preper.setInt	(5,id);
	    	
			preper.execute();
			 int updateCount = preper.getUpdateCount();
			  
			 return updateCount;
		
		
	}catch(Exception ee) {
		ee.printStackTrace();
	};
		}
	return id;
	
	
	}
	private void Seleccionar(JTable tablaReserva) {
		
	}


}

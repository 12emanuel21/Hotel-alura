package funcionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Factory.conexionDB_alura;

import modelo.Huespedes;
import modelo.Reserva;


public class HuespedesDAO {




final private Connection con;
	
	
	public HuespedesDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar (Huespedes huespedes)  {
		
		try(con){
		  	
		  	 final PreparedStatement statement = con.prepareStatement(
		  			"INSERT INTO hotel_alura_one_orecle.huespedes"
							+ "(id, Nombre, Apallido, Fecha_de_nacimiento, Nacionalida, Telefono, reservas)"					
							+ "VALUES"
							+"(?,?,?,?,?,?)",
	                        Statement.RETURN_GENERATED_KEYS);
		  	 try(statement) {
	               		    
	            ejecutaRegistro(huespedes, statement);
	    
	          
		  	 }
	}catch(SQLException e) {
	
		throw new RuntimeException(e);
	}
}
	 private void ejecutaRegistro(Huespedes huespedes, PreparedStatement statement)
	            throws SQLException {
		 statement.setString(1, huespedes.getNombre());
		 statement.setString(2, huespedes.getApellido());
		 statement.setObject(3, huespedes.getFechaNacimiento());
		 statement.setString(4, huespedes.getNacionalidad());
		 statement.setString(5, huespedes.getTelefono());
		 statement.setInt(6, huespedes.getIdReserva());
		 statement.executeUpdate();
	        final ResultSet resultSet = statement.getGeneratedKeys();
	        
	        try(resultSet) {
	            while (resultSet.next()) {
	            	huespedes.setId(resultSet.getInt(1));
	                System.out.println(String.format("Fue insertado el producto %s", huespedes));
         }
   }
	 }
	 
	 public static List<Huespedes> listar() {
		 List<Huespedes> resultado = new ArrayList<>();
			
		 conexionDB_alura factory = new conexionDB_alura();
			
			final Connection con = factory.ConectarConexion();
			
			try(con){
			PreparedStatement statement  = con.prepareStatement("SELECT ID,Fecha_Entrada,Fecha_Salida,Forma_de_Pago,valor FROM hotel_alura_challenge_one.reservas");
			
			try(statement){
			statement.execute();
			
			final ResultSet resultSet =statement.getResultSet();
			
			
			try(resultSet){
				
			
			while(resultSet.next()){
				Huespedes fila = new Huespedes(resultSet.getInt("ID"),
						resultSet.getString("NOMBRE"),
						resultSet.getString("APELLIDO"),
						resultSet.getString("Fecha_de_nacimiento"),
						resultSet.getString("Nacionalidad"),
						resultSet.getString("Telefono"),
						resultSet.getInt("reservas")); 
				
				
				resultado.add(fila);
						}
					}
			}
			
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		return resultado;
	}
}

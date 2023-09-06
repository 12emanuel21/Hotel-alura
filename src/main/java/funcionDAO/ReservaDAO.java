package funcionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import modelo.Reserva;



public class ReservaDAO {


final private Connection con;
	
	
	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	
	
	
	public void guardar (Reserva reserva)  {
		
		try(con){
		  	
		  	 final PreparedStatement statement = con.prepareStatement(
		  			"INSERT INTO Hotel_Alura_Challenge_ONE.reservas"
							+ "(Fecha_Entrada, Fecha_Salida, Forma_de_Pago,valor)"					
							+ "VALUES (?,?,?,?)",
	                        Statement.RETURN_GENERATED_KEYS);
		  	 try(statement) {
	               		    
	            ejecutaRegistro(reserva, statement);
	    
	          
		  	 }
	}catch(SQLException e) {
	
		throw new RuntimeException(e);
	}
}
	 private void ejecutaRegistro(Reserva reserva, PreparedStatement statement)
	            throws SQLException {
		 statement.setString(1, reserva.getCopyinicio());
		 statement.setString(2, reserva.getCopysale());
		 statement.setString(3, reserva.getFormaPago());
		 statement.setString(4, reserva.getValor());
		 statement.executeUpdate();

	        final ResultSet resultSet = statement.getGeneratedKeys();
	        
	        try(resultSet) {
	            while (resultSet.next()) {
	            	reserva.setId(resultSet.getInt(1));
	                System.out.println(String.format("Fue insertado el producto %s", reserva));
         }
   }
	 }
	 
	 private void mostrarReserva() {
		 try {
				Statement state = con.createStatement();
				String query="SELECT * FROM reservasgood;";
				ResultSet rs= state.executeQuery(query);
				ResultSetMetaData rsmd = rs.getMetaData();
				DefaultTableModel model = new DefaultTableModel();
				
				int colum = rsmd.getColumnCount();
				String[] colName=new String[colum];
				for(int i=0;i<colum;i++ ) {
					colName[i]=rsmd.getCatalogName(i+1);
					model.setColumnIdentifiers(colName);
					String id,FE,FS,FP,VA;
					while(rs.next()) {
						id=rs.getString(1);
						FE=rs.getString(2);
						FS=rs.getString(3);
						FP=rs.getString(4);
						VA=rs.getString(5);
						String[] row = {id,FE,FS,FP,VA};
						model.addRow(row);
						
					}
				}
				state.close();
				con.close();
				
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	 
	 public List<Reserva> listar() {
	        List<Reserva> resultado = new ArrayList<>();

	        try {
	            final PreparedStatement statement = con
	                    .prepareStatement("SELECT ID, FechaEntrada, FechaSalida, valor, FormaDePago FROM reservasgood");
	    
	            try (statement) {
	                statement.execute();
	    
	                final ResultSet resultSet = statement.getResultSet();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                        resultado.add(new Reserva(
	                        		resultSet.getInt("ID"),
	                        		resultSet.getString("FechaEntrada"),
	                        		resultSet.getString("FechaSalida"),
	                        		resultSet.getString("valor"),
	                        		resultSet.getString("FormaDePago"))); 
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	        return resultado;
	    }
}

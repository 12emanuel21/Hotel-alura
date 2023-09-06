package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.CallableStatement;

import Factory.conexionDB_alura;

public class Reserva {


	
	private Integer id;
	private String copyinicio;
	private String copysale;
	private String valor;
	private String formaPago;
	
	public Reserva(Integer id, String copyinicio, String copysale, String valor, String formaPago) {
		super();
		this.id = id;
		this.copyinicio = copyinicio;
		this.copysale = copysale;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reserva(String copyinicio, String copysale, String valor, String formaPago) {
		this.copyinicio = copyinicio;
		this.copysale = copysale;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getCopyinicio() {
		return copyinicio;
	}

	public void setCopyinicio(String copyinicio) {
		this.copyinicio = copyinicio;
	}

	public String getCopysale() {
		return copysale;
	}

	public void setCopysale(String copysale) {
		this.copysale = copysale;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public void Eliminar(JTextField id){
	    
        setId(Integer.parseInt(id.getText()));
        
        conexionDB_alura factory = new conexionDB_alura();
    	
    	Connection con = factory.ConectarConexion();
        
        String consulta = "DELETE FROM Alumnos WHERE alumnos.id=?;";
        
        try {
             CallableStatement cs = (CallableStatement) factory.ConectarConexion().prepareCall(consulta);
             cs.setInt(1, getId());
             cs.execute();
             
             JOptionPane.showMessageDialog(null,"Se eliminó correctamente el Alumno");
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"No se pudo eliminar, error: "+ e.toString());
        }
        
    }
	
	
}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import VIEW_Hotel_alura.Menu_opciones;
import VIEW_Hotel_alura.loginView;
import modelo.Usuarios;



public class UsuarioController implements ActionListener{

private loginView vista;
	
	public UsuarioController(loginView vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = vista.getNombre();
		String pass = vista.getPassword();
		
		if (Usuarios.validarUsuario(nombre, pass)) {
			Menu_opciones menu = new Menu_opciones();
			menu.setVisible(true);
			vista.dispose();
		}else {
			JOptionPane.showMessageDialog(vista, "Usuario o Contraseña no validos");
			
		}
	}

}

package VIEW_Hotel_alura;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.w3c.dom.Text;

import Controller.HuespedesController;
import Controller.ReservaController;
import Factory.conexionDB_alura;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;

public class BuscarView extends JFrame {

	private JPanel contentPane;

	private ReservaController reservaController;
	private HuespedesController huespedesController;
	private ReservasView reservasView;
	private JTextField txtBuscar;
	private DefaultTableModel modelo;
	String Reserva;
	String Huespedes;
	private JTable tablaReserva;
	private JTable tablaHuespedes;
	conexionDB_alura conn = new conexionDB_alura();
	Connection con = conn.ConectarConexion();
	private modelo.Reserva reserva;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarView frame = new BuscarView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuscarView() {
		  
		this.reservaController = new ReservaController();
		this.huespedesController = new HuespedesController();
		this.reservasView = new ReservasView();
		
	   
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setUndecorated(true);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 129, 708, 296);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\persona.png");
		ImageIcon icon2 = new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\calendario.png");
		
		
		txtBuscar = new JTextField();
		txtBuscar.setForeground(new Color(0, 206, 209));
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				 
				 TablaHuespedes(txtBuscar.getText());
				 TablaReserva(txtBuscar.getText());
				 
			}
		});
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(new Color(0, 139, 139));
		lblBuscar.setBackground(new Color(0, 206, 209));
		lblBuscar.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setBounds(700, 100, 76, 25);
		contentPane.add(lblBuscar);
		txtBuscar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		txtBuscar.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtBuscar.setBounds(505, 100, 185, 25);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		contentPane.add(tabbedPane);
		
		String []  nombresColumnas = {"ID","FECHA ENTRADA","FECHA SALIDA","FORMA DE PAGO","VALOR"};
		JPanel reservas = new JPanel();
		tabbedPane.addTab("Reservas", icon2, reservas, null);
		reservas.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 683, 236);
		reservas.add(scrollPane);
		
		tablaReserva = new JTable();
		tablaReserva.setModel(new DefaultTableModel(null,nombresColumnas));
		
		scrollPane.setViewportView(tablaReserva);
		
		 
		
		JPanel huespedes = new JPanel();
		tabbedPane.addTab("Huéspedes", icon, huespedes, null);
		huespedes.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 683, 236);
		huespedes.add(scrollPane_1);
		
		tablaHuespedes = new JTable();
		tablaHuespedes.setModel(new DefaultTableModel(null,nombresColumnas));
		
		scrollPane_1.setViewportView(tablaHuespedes);
		
		label();
		 
		 TablaHuespedes("");
		 TablaReserva("");
		
		JLabel fondo = new JLabel("");
		fondo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		fondo.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\backgroud_Ice.jpg"));
		fondo.setHorizontalAlignment(SwingConstants.CENTER);
		fondo.setBounds(0, 0, 803, 513);
		contentPane.add(fondo);
	}
	private void label() {
		
		JLabel lblNewLabel_1 = new JLabel("<");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu_opciones logini = new Menu_opciones();
				logini.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 30, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Ha-100px.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(52, 11, 120, 107);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sistema de Busqueda");
		lblNewLabel_3.setForeground(new Color(0, 153, 153));
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(231, 32, 332, 41);
		contentPane.add(lblNewLabel_3);	
		
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
					
					try {
						cerrarConexion();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\cerrar-24px.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(754, 11, 36, 34);
			contentPane.add(lblNewLabel);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(tablaReserva.getSelectedRow() >=0 ){
					
					Borrar();
					
					
				}else if(tablaHuespedes.getSelectedRow()>=0) {
					
					borrarHuespedes();
				}else{
			         JOptionPane.showMessageDialog(null,"Seleccione fila");
			     }
		
			}
				
		});
		botonEliminar.setForeground(new Color(245, 255, 250));
		botonEliminar.setFont(new Font("SansSerif", Font.BOLD, 14));
		botonEliminar.setBackground(new Color(0, 206, 209));
		botonEliminar.setBounds(28, 456, 100, 23);
		contentPane.add(botonEliminar);
	
	JButton btnModificar = new JButton("Modificar");
	btnModificar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(tablaReserva.getSelectedRow() >=0 ){
				
				
				ActualizarDatosReserva();
				
			}else if(tablaHuespedes.getSelectedRow()>=0) {
				
				ActualizarDatosHuespedes();
			}else{
		         JOptionPane.showMessageDialog(null,"Seleccione fila");
		     }
	
		}
			
	});
	btnModificar.setForeground(new Color(245, 255, 250));
	btnModificar.setFont(new Font("SansSerif", Font.BOLD, 14));
	btnModificar.setBackground(new Color(0, 206, 209));
	btnModificar.setBounds(138, 456, 114, 23);
	contentPane.add(btnModificar);
	

	}
	

	
	private void TablaReserva(String FechaEntrada) {
		 DefaultTableModel modelo=new DefaultTableModel();
		    modelo.addColumn("id");
		    modelo.addColumn("FechaEntrada");
		    modelo.addColumn("FechaSalida");    
		    modelo.addColumn("Valor");
		    modelo.addColumn("FormadePago");
		    tablaReserva.setModel(modelo);
		    String sql="";
		    if(FechaEntrada.equals("")){
		        sql="Select*from reservasgood";
		    }else{
		        sql="Select*from reservasgood where FechaEntrada like'%"+FechaEntrada+"%'";
		    }
		    String Usuarios[]=new String[5];
		    Statement set;
		    try {
		        set = con.createStatement(); 
		        ResultSet resul=set.executeQuery(sql);
		        while(resul.next()){
		            Usuarios[0]=resul.getString(1);
		              Usuarios[1]=resul.getString(2);
		                Usuarios[2]=resul.getString(3);  
		                Usuarios[3]=resul.getString(4);
		                  Usuarios[4]=resul.getString(5);
		                  modelo.addRow(Usuarios);
		                  
		                
		        }
		        tablaReserva.setModel(modelo);
		    } catch (SQLException ex) {
		       ex.printStackTrace();
		    }
		   

		    
	}
		private void TablaHuespedes(String Nombre) {
			DefaultTableModel modelo=new DefaultTableModel();
		    modelo.addColumn("id");
		    modelo.addColumn("Nombre");
		    modelo.addColumn("Apallido");    
		    modelo.addColumn("FechaDeNacimiento");
		    modelo.addColumn("Nacionalidad");
		    modelo.addColumn("Telefono");
		    modelo.addColumn("Reservas");
		    tablaHuespedes.setModel(modelo);
		    String sql="";
		    if(Nombre.equals("")){
		        sql="SELECT * FROM hotel_alura_challenge_one.huespedes";
		    }else{
		        sql="SELECT * FROM hotel_alura_challenge_one.huespedes where Nombre like'%"+Nombre+"%'";
		    }
		    String Usuarios[]=new String[7];
		    Statement set;
		    try {
		        set = con.createStatement(); 
		        ResultSet resul=set.executeQuery(sql);
		        while(resul.next()){
		            Usuarios[0]=resul.getString(1);
		              Usuarios[1]=resul.getString(2);
		                Usuarios[2]=resul.getString(3);  
		                Usuarios[3]=resul.getString(4);
		                Usuarios[4]=resul.getString(5);
		                Usuarios[5]=resul.getString(6);
		                  Usuarios[6]=resul.getString(7);
		                  modelo.addRow(Usuarios);
		                  
		                
		        }
		        tablaHuespedes.setModel(modelo);
		    } catch (SQLException ex) {
		       ex.printStackTrace();
		    }
			   
	}
		private void cerrarConexion() throws SQLException {
			
			con.close();
		}
		  public void borrarHuespedes() {
			  int filaHuespedes = tablaHuespedes.getSelectedRow();
			   String Id=tablaHuespedes.getValueAt(filaHuespedes,0).toString();
			   int n=JOptionPane.showConfirmDialog(null,"Desea eliminar registro","Registro",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			    if(n==JOptionPane.YES_NO_OPTION) {
			    	try {
			    		
			    	PreparedStatement borrarH=con.prepareStatement("DELETE FROM hotel_alura_challenge_one.huespedes WHERE id='"+Id+"'");
			        
			    	borrarH.executeUpdate();	
			         TablaHuespedes("");
			    	
			    
		    } catch (SQLException ex) {
		    	 ex.printStackTrace();
		    }
			}
}
	  
		  
		  public void ActualizarDatosHuespedes() {
			  int fila = tablaHuespedes.getSelectedRow();
			  int id = Integer.parseInt(this.tablaHuespedes.getValueAt(fila, 0).toString());
			  String na = tablaHuespedes.getValueAt(fila, 1).toString();
			  String lastNa = tablaHuespedes.getValueAt(fila, 2).toString();
			  String FN = tablaHuespedes.getValueAt(fila, 3).toString();
			  String Nacionalidad = tablaHuespedes.getValueAt(fila, 4).toString();
			  String Telefomo = tablaHuespedes.getValueAt(fila, 5).toString();
			  String Reserva = tablaHuespedes.getValueAt(fila, 6).toString();
			  
			  try {
				  
				  String sql ="UPDATE hotel_alura_challenge_one.huespedes SET Nombre='"+na+"'"
					  		+ ",Apallido='"+lastNa+"',FechaDeNacimiento='"+FN+"',Nacionalidad='"+Nacionalidad+"',Telefono='"
							  +Telefomo+"',Reservas='"+Reserva+"' WHERE id='"+id+"'";
				  
				  String sql3 ="UPDATE hotel_alura_challenge_one.huespedes SET Nombre='"+na+"' WHERE id='"+id+"'";
				  PreparedStatement preper = con.prepareStatement(sql);
				  
				  preper.executeUpdate();
				  TablaHuespedes("");
				  
				  
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null," error en modificardatos");
			    	 e.printStackTrace();
			  }
		  }
		  public void ActualizarDatosReserva() {
			  int fila = tablaReserva.getSelectedRow();
			  int id = Integer.parseInt(this.tablaReserva.getValueAt(fila, 0).toString());
			  String Fe = tablaReserva.getValueAt(fila, 1).toString();
			  String Fs = tablaReserva.getValueAt(fila, 2).toString();
			  String Valor = tablaReserva.getValueAt(fila, 3).toString();
			  String pago = tablaReserva.getValueAt(fila, 4).toString();
			  
			  try {
				  
				  PreparedStatement pre = con.prepareStatement("UPDATE hotel_alura_challenge_one.reservasgood SET FechaEntrada='"+Fe+"',FechaSalida='"
						  +Fs+"',Valor='"+Valor+"',FormadePago='"+pago+"' WHERE id='"+id+"'");
				  pre.executeUpdate();
				  TablaReserva("");
				  pre.close();
				  
			  }catch(Exception e){
				  JOptionPane.showMessageDialog(null," error en modificardatos");
			    	 e.printStackTrace();
			  }
			  
		  }
		  
		  public void Borrar(){
			    int fila=tablaReserva.getSelectedRow();
			    
			    String Identidad=tablaReserva.getValueAt(fila,0).toString();
			   
			    int n=JOptionPane.showConfirmDialog(null,"Desea eliminar registro","Registro",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			    if(n==JOptionPane.YES_NO_OPTION){
			    try {
			    	
			    		PreparedStatement borrar=con.prepareStatement("Delete from reservasgood where id='"+Identidad+"'");
			    		borrar.executeUpdate();
			    		TablaReserva("");
			    	
        
			       
			    } catch (SQLException ex) {
			    	 ex.printStackTrace();
			    }
			    }
			}
		  
	
		
		  
		
		  
}

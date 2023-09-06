package VIEW_Hotel_alura;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

import Factory.conexionDB_alura;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;



public class ReservasView extends JFrame {

	conexionDB_alura conn = new conexionDB_alura();
	Connection con = conn.ConectarConexion();
	
	private JDateChooser jdFechaE;
	private JDateChooser jdFechaS;
	private JPanel contentPane;

	private JTextField textcopy;
	private JTextField copyTextS;
	private JTextField txtvalor;
	private JComboBox credito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
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
	public ReservasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 206, 209)));

		setUndecorated(true);
		setResizable(false);
		this.setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Ha-100px.png"));
		lblNewLabel_5.setBounds(566, 11, 106, 101);
		contentPane.add(lblNewLabel_5);
		ImageIcon icon = new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\calendario.png");
		JDateChooser jdFechaE = new JDateChooser();
		jdFechaE.getCalendarButton().setBackground(new Color(224, 255, 255));
		jdFechaE.setDateFormatString("yyyy/MM/dd");
		jdFechaE.setBackground(new Color(0, 139, 139));
		jdFechaE.setIcon(icon);
		jdFechaE.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 206, 209)));
		jdFechaE.setBounds(36, 134, 237, 38);
		jdFechaE.setDateFormatString("yyyy/MM/dd");
		jdFechaE.setBounds(48, 134, 225, 38);
		contentPane.add(jdFechaE);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\reservas-img-3.png"));
		lblNewLabel_2.setBounds(370, 116, 501, 305);
		contentPane.add(lblNewLabel_2);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\cerrar-24px.png"));
		lblNewLabel.setBounds(849, 0, 32, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Blue Coral.jpg"));
		lblNewLabel_1.setBounds(352, 0, 529, 513);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Sistema de reservas");
		lblNewLabel_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(48, 38, 246, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Check in");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_4.setBounds(36, 98, 175, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Fecha de Check out");
		lblNewLabel_4_1.setForeground(Color.GRAY);
		lblNewLabel_4_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(36, 183, 175, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("VALOR DE RESERVA");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_2.setForeground(Color.GRAY);
		lblNewLabel_4_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(38, 285, 235, 14);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Formato de Pago");
		lblNewLabel_4_3.setForeground(Color.GRAY);
		lblNewLabel_4_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(36, 369, 146, 26);
		contentPane.add(lblNewLabel_4_3);
		
		
		
		
		
		///////////////////
		textcopy = new JTextField();
		textcopy.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 206, 209)));
		textcopy.setBounds(0, 511, 37, 2);
		contentPane.add(textcopy);
		textcopy.setColumns(10);
		
		
		copyTextS = new JTextField();
		copyTextS.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 206, 209)));
		copyTextS.setColumns(10);
		copyTextS.setBounds(246, 511, 37, 2);
		contentPane.add(copyTextS);
		
			JDateChooser jdFechaS = new JDateChooser();
			jdFechaS.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					calcularValor(jdFechaE, jdFechaS);
				}
			});
			jdFechaS.getCalendarButton().setBackground(new Color(224, 255, 255));
			jdFechaS.setDateFormatString("yyyy/MM/dd");
			jdFechaS.setBackground(new Color(0, 139, 139));
			jdFechaS.setIcon(icon);
			jdFechaS.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 206, 209)));
			jdFechaS.setBounds(36, 210, 235, 38);
			jdFechaS.setDateFormatString("yyyy/MM/dd");
			jdFechaS.setBounds(46, 210, 225, 38);
			contentPane.add(jdFechaS);
		
		txtvalor = new JTextField();
		txtvalor.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtvalor.setOpaque(false);
		txtvalor.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 206, 209)));
		txtvalor.setBounds(36, 327, 237, 26);
		contentPane.add(txtvalor);
		txtvalor.setColumns(10);
		
		
		credito = new JComboBox();
		credito.setModel(new DefaultComboBoxModel(new String[] {"Targeta de Credito", "Targeta de Devito", "Dinero en efectivo"}));
		credito.setBounds(48, 406, 225, 32);
		contentPane.add(credito);
		
		JButton btn_boton = new JButton("Siguiente");
		btn_boton.setForeground(new Color(240, 248, 255));
		btn_boton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btn_boton.setBackground(new Color(0, 206, 209));
		btn_boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jdFechaE.getDate() != null && jdFechaS.getDate() != null ) {
					String select = ((JTextField)jdFechaE.getDateEditor().getUiComponent()).getText();
					
					textcopy.setText(select);
					String select2 = ((JTextField)jdFechaS.getDateEditor().getUiComponent()).getText();
					
					copyTextS.setText(select2);
					guardar();
				
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "llenar todos los campos");
				}
			}
		});
		
		btn_boton.setBounds(108, 466, 99, 23);
		contentPane.add(btn_boton);
		
		JLabel lblNewLabel_6 = new JLabel("<");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu_opciones logini = new Menu_opciones();
				logini.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(10, 11, 24, 15);
		contentPane.add(lblNewLabel_6);
		 		
		
	}
	
	
	
	
	
	public void guardar() {
		
		String sql = "INSERT INTO Hotel_Alura_Challenge_ONE.ReservasGood(FechaEntrada, FechaSalida, Valor,FormadePago)VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			
			pre.setString(1, textcopy.getText());
			pre.setString(2, copyTextS.getText());
			pre.setString(3, txtvalor.getText());
			pre.setString(4, credito.getSelectedItem().toString());
			
			
			//pre.setString(1, ((JTextField)jdFecha.getDateEditor().getUiComponent()).getText());
			
			pre.execute();
			
			JOptionPane.showMessageDialog(null, "fecha ingresada con exito");
			RegistroHuespedesViewll registro = new RegistroHuespedesViewll	();
			registro.setVisible(true);
			dispose();
			con.close();
		}catch(SQLException e) {
			new RuntimeException(e);
			JOptionPane.showMessageDialog(null, "error registro" + e.getMessage());
		}
	}
	public void calcularValor(JDateChooser dateE,JDateChooser dateS ) {
		if (dateE.getDate()!=null && dateS.getDate()!=null) {
			if(dateE.getDate().after(dateS.getDate())) {
				JOptionPane.showMessageDialog(null, "La Fecha de entrada no puede ser porterior a la Fecha de salida",
						"Error en Fechas", JOptionPane.ERROR_MESSAGE);
				return;	
			}
			
			Calendar inicio = dateE.getCalendar();
			Calendar fin = dateS.getCalendar();
			
			int dias = -1;//para que cuente desde el dia siguiente
			int noche =3000;
			int valor;
			
			while (inicio.before(fin)|| inicio.equals(fin)) {
				dias++;
				inicio.add(Calendar.DATE, 1);
			}
			valor= dias*noche;
			txtvalor.setText("$: "+valor);
		}
	}
}

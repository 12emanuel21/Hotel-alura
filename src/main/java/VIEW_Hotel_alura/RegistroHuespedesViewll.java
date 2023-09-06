package VIEW_Hotel_alura;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import Factory.conexionDB_alura;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class RegistroHuespedesViewll extends JFrame {
	
	conexionDB_alura conn = new conexionDB_alura();
	Connection con = conn.ConectarConexion();

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNReserva;
	private JTextField txtFecha;
	private JDateChooser FechaNacimiento;
	private JComboBox txtNacionalidad;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHuespedesViewll frame = new RegistroHuespedesViewll();
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
	public RegistroHuespedesViewll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 513);
		contentPane = new JPanel();
		
		setUndecorated(true);
		setResizable(false);
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\aH-40px.png"));
		lblNewLabel_4.setBounds(519, 0, 46, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("<");
		lblNewLabel_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView registro = new ReservasView();
				registro.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(32, 11, 23, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\registro.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 566, 513);
		contentPane.add(lblNewLabel_3);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\cerrar-24px.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(847, 0, 34, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Blue Coral.jpg"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 566, 513);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Registro de Huéspedes");
		lblNewLabel_5.setForeground(new Color(0, 139, 139));
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(594, 11, 240, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre");
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_6.setBounds(594, 43, 68, 21);
		contentPane.add(lblNewLabel_6);
		
		//////////////////////////
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.setForeground(Color.GRAY);
		txtNombre.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		txtNombre.setBounds(594, 75, 235, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Apellido");
		lblNewLabel_6_1.setForeground(Color.GRAY);
		lblNewLabel_6_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(594, 117, 68, 21);
		contentPane.add(lblNewLabel_6_1);
		
		txtApellido = new JTextField();
		txtApellido.setOpaque(false);
		txtApellido.setForeground(Color.GRAY);
		txtApellido.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtApellido.setColumns(10);
		txtApellido.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		txtApellido.setBounds(594, 149, 235, 20);
		contentPane.add(txtApellido);
		
		JLabel lblNewLabel_6_2 = new JLabel("Telefono");
		lblNewLabel_6_2.setForeground(Color.GRAY);
		lblNewLabel_6_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_6_2.setBounds(594, 334, 68, 21);
		contentPane.add(lblNewLabel_6_2);
		
ImageIcon icon = new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\calendario.png");
		
		JDateChooser FechaNacimiento = new JDateChooser();
		FechaNacimiento.setDateFormatString("yyyy/MM/dd");
		FechaNacimiento.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		FechaNacimiento.setIcon(icon);
		FechaNacimiento.setBounds(594, 222, 231, 31);
		contentPane.add(FechaNacimiento);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setForeground(Color.GRAY);
		lblNacionalidad.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNacionalidad.setBounds(594, 263, 103, 21);
		contentPane.add(lblNacionalidad);
		
		txtNacionalidad = new JComboBox();
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
		txtNacionalidad.setBounds(594, 289, 240, 34);
		txtNacionalidad.setBackground(SystemColor.text);
		txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		contentPane.add(txtNacionalidad);
		
		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setForeground(Color.GRAY);
		txtTelefono.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		txtTelefono.setBounds(594, 366, 235, 20);
		contentPane.add(txtTelefono);
		
		JLabel lblNewLabel_6_3 = new JLabel("Numero de Reserva");
		lblNewLabel_6_3.setForeground(Color.GRAY);
		lblNewLabel_6_3.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_6_3.setBounds(594, 393, 185, 21);
		contentPane.add(lblNewLabel_6_3);
		
		txtNReserva = new JTextField();
		
		txtNReserva.setOpaque(false);
		txtNReserva.setForeground(Color.GRAY);
		txtNReserva.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNReserva.setColumns(10);
		txtNReserva.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 153)));
		txtNReserva.setBounds(594, 427, 235, 20);
		
		contentPane.add(txtNReserva);
		
		txtFecha = new JTextField();
		txtFecha.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 206, 209)));
		txtFecha.setBounds(576, 512, 86, 1);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		btnNewButton = new JButton("Siguiente");
		btnNewButton.setForeground(new Color(248, 248, 255));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FechaNacimiento.getDate() != null&&!txtNombre.equals("")&&!txtApellido.equals("")) {
					String select = ((JTextField)FechaNacimiento.getDateEditor().getUiComponent()).getText();
					
					txtFecha.setText(select);
					
					guardar();
					
				
					
				}else {
					
					JOptionPane.showMessageDialog(null, "llenar todos los campos");
					
				}
			}
		});
		btnNewButton.setBounds(731, 463, 103, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_6_1_1.setForeground(Color.GRAY);
		lblNewLabel_6_1_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_6_1_1.setBounds(594, 190, 165, 21);
		contentPane.add(lblNewLabel_6_1_1);
	}
	
public void guardar() {
		
		String sql = "INSERT INTO hotel_alura_challenge_one.huespedes(Nombre, Apallido, FechaDeNacimiento,Nacionalidad,Telefono,reservas)VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			
			pre.setString(1, txtNombre.getText());
			pre.setString(2, txtApellido.getText());
			pre.setString(3, txtFecha.getText());
			pre.setString(4, txtNacionalidad.getSelectedItem().toString());
			pre.setString(5, txtTelefono.getText());
			pre.setString(6, txtNReserva.getText());
			
			
			//pre.setString(1, ((JTextField)jdFecha.getDateEditor().getUiComponent()).getText());
			
			pre.execute();
			
			//JOptionPane.showMessageDialog(null, "fecha ingresada con exito");
			Exito registro = new Exito();
			registro.setVisible(true);
			dispose();
			con.close();
		}catch(SQLException e) {
			new RuntimeException(e);
			JOptionPane.showMessageDialog(null, "error registro " + e.getMessage());
		}
	}
}

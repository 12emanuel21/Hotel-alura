package VIEW_Hotel_alura;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class Menu_opciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_opciones frame = new Menu_opciones();
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
	public Menu_opciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 153, 204)));
		
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
		
		
		LocalDate fechaActual = LocalDate.now();

      
		
		JLabel lbl_fecha = new JLabel("Fecha actual: "+fechaActual);
		lbl_fecha.setForeground(SystemColor.textHighlightText);
		lbl_fecha.setFont(new Font("SansSerif", Font.BOLD, 19));
		
		
		lbl_fecha.setBounds(347, 105, 245, 24);
		contentPane.add(lbl_fecha);
		
		JLabel lblNewLabel_7_1_1_1_1_1_2 = new JLabel("- Eliminar todo tipo de registro");
		lblNewLabel_7_1_1_1_1_1_2.setForeground(SystemColor.windowBorder);
		lblNewLabel_7_1_1_1_1_1_2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_7_1_1_1_1_1_2.setBounds(357, 437, 440, 24);
		contentPane.add(lblNewLabel_7_1_1_1_1_1_2);
		
		JLabel lblNewLabel_7_1_1_1_1_1_1 = new JLabel("- Edicion de reservas y huéspedes");
		lblNewLabel_7_1_1_1_1_1_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_7_1_1_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_7_1_1_1_1_1_1.setBounds(357, 406, 440, 24);
		contentPane.add(lblNewLabel_7_1_1_1_1_1_1);
		
		JLabel lblNewLabel_7_1_1_1_1_1 = new JLabel("- Registro de Reservas");
		lblNewLabel_7_1_1_1_1_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_7_1_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_7_1_1_1_1_1.setBounds(357, 374, 440, 24);
		contentPane.add(lblNewLabel_7_1_1_1_1_1);
		
		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("especificas como lo son.");
		lblNewLabel_7_1_1_1_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_7_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_7_1_1_1_1.setBounds(357, 329, 440, 24);
		contentPane.add(lblNewLabel_7_1_1_1_1);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("reservas y huéspedes. tendra acceso a herramientas especiales para tareas");
		lblNewLabel_7_1_1_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_7_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_7_1_1_1.setBounds(357, 306, 440, 24);
		contentPane.add(lblNewLabel_7_1_1_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Esta herramienta le permite llevar un control completo y detallado de sus");
		lblNewLabel_7_1_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_7_1_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_7_1_1.setBounds(357, 282, 440, 24);
		contentPane.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("el flujo de reservas y huéspedes del hotel");
		lblNewLabel_7_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_7_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_7_1.setBounds(357, 252, 440, 24);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7 = new JLabel("Sistema de reserve de Hotel.  Controle y administre de forma optima y facil ");
		lblNewLabel_7.setForeground(SystemColor.windowBorder);
		lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(357, 228, 440, 24);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Bienvenidos");
		lblNewLabel_6.setForeground(new Color(30, 30, 30));
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_6.setBounds(347, 186, 159, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Sistema de Reservas Hotel Alura");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(371, 70, 401, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Sky.jpg"));
		lblNewLabel_5.setBounds(294, 60, 587, 92);
		contentPane.add(lblNewLabel_5);
		
		JLabel lbl_login = new JLabel("Login");
		lbl_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginView logini = new loginView();
				logini.setVisible(true);
				dispose();
			}
		});
		lbl_login.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\persona.png"));
		lbl_login.setForeground(Color.WHITE);
		lbl_login.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_login.setBounds(27, 306, 180, 33);
		lbl_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lbl_login);
		
		JLabel lbl_busqueda = new JLabel("Búsqueda");
		lbl_busqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuscarView buscar = new BuscarView();
				buscar.setVisible(true);
				dispose();
			}
		});
		lbl_busqueda.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\icon-buscar.png"));
		lbl_busqueda.setForeground(Color.WHITE);
		lbl_busqueda.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_busqueda.setBounds(27, 262, 180, 33);
		lbl_busqueda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lbl_busqueda);
		
		JLabel lbl_registro = new JLabel("Registro de Reservas");
		lbl_registro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reserva = new ReservasView();
				reserva.setVisible(true);
				dispose();
			}
		});
		lbl_registro.setForeground(new Color(255, 255, 255));
		lbl_registro.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_registro.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\reservado.png"));
		lbl_registro.setBounds(27, 218, 180, 33);
		lbl_registro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lbl_registro);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\aH-150px.png"));
		lblNewLabel_3.setBounds(27, 25, 235, 159);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Powder Blue.jpg"));
		lblNewLabel_2.setBounds(0, 0, 294, 513);
		contentPane.add(lblNewLabel_2);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\cerrar-24px.png"));
		lblNewLabel.setBounds(851, 0, 30, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\backgroud_Ice.jpg"));
		lblNewLabel_1.setBounds(234, 0, 647, 513);
		contentPane.add(lblNewLabel_1);
	}
}

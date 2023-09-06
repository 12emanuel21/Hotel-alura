package VIEW_Hotel_alura;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class Inicio_hotel_alura {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio_hotel_alura window = new Inicio_hotel_alura();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio_hotel_alura() {
		frame = new JFrame();
		frame.setBounds(100, 100, 881, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		/*
		 * el si guiente codigo es para quitar los botones de cerrar y minimizar
		 */
		
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		/*
		 *_/////////////////////////////////////////////////////////////////////////
		 */
		
		/*
		 * este codigo es un evento de click para cerrar el frame actual y abrir otro
		 */
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(153, 204, 204));
		lblNewLabel_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
lblNewLabel_3.setOpaque(false);		
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginView newframe = new loginView();
				newframe.setVisible(true);
				
				frame.dispose();
			}
		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\login.png"));
		lblNewLabel_3.setBounds(617, 231, 254, 74);

		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\cerrar-24px.png"));
		lblNewLabel_5.setBounds(835, -1, 46, 34);
		lblNewLabel_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Ingresar");
		lblNewLabel_4.setForeground(new Color(0, 153, 204));
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_4.setBounds(714, 181, 70, 39);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\aH-150px.png"));
		lblNewLabel.setBounds(666, -1, 150, 193);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Desarrollado Por Emanuel Vargas Grupo5 ONE Oracle Alura 2023");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1.setBackground(new Color(0, 153, 153));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 479, 845, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(51, 204, 204));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\backgroud_Ice.jpg"));
		lblNewLabel_2.setBounds(601, -1, 280, 469);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\menu-img.png"));
		label_1.setBounds(0, -1, 607, 469);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Blue Coral.jpg"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBackground(new Color(0, 153, 153));
		lblNewLabel_1_1.setBounds(0, 462, 881, 51);
		frame.getContentPane().add(lblNewLabel_1_1);
	}
}

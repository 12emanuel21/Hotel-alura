package VIEW_Hotel_alura;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Controller.UsuarioController;
import Librery.placeholdertext;



public class loginView extends JFrame {

	private JPanel contentPanel;
	
	private JTextField txt_user;
	private JTextField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginView frame = new loginView();
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
	public loginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 513);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setResizable(false);
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		/*
		 * centra la ventana principal
		 */
		this.setLocationRelativeTo(null);
		/*
		 * -///////////////////////
		 */
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				/*-esto es una caja que pregunta si quiere salir
				 * int a = JOptionPane.YES_NO_CANCEL_OPTION;
				 
				int resultado = JOptionPane.showConfirmDialog(lblNewLabel_3, "¿Desea Salir?","Salir",a);
			
				if(resultado == 0) {
					
				}**/
			
				System.exit(0);
			}
		});
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new UsuarioController(this));
			
		
		btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JToggleButton ToggleButton = new JToggleButton("");
		ToggleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ToggleButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		ToggleButton.setBackground(new Color(248, 248, 255));
		/*
		 * quitar background 
		 */
		ToggleButton.setOpaque(false);
		/*
		 * 
		 */
		ToggleButton.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\lupa2.png"));
		ToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ToggleButton.isSelected()) {
					((JPasswordField) txt_password).setEchoChar((char)0);
				}else {
					((JPasswordField) txt_password).setEchoChar('*');
				}
			}
		});
	
		ToggleButton.setBounds(496, 316, 33, 32);
		contentPanel.add(ToggleButton);
		btnEntrar.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\perfil-del-usuario.png"));
		btnEntrar.setForeground(new Color(0, 206, 209));
		btnEntrar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnEntrar.setBorder(new LineBorder(new Color(0, 139, 139)));
		btnEntrar.setBackground(new Color(230, 230, 250));
		btnEntrar.setBounds(109, 390, 106, 30);
		contentPanel.add(btnEntrar);
		
		txt_password = new JPasswordField();
		txt_password.addKeyListener(new KeyAdapter() {
			
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						btnEntrar.requestFocusInWindow();
					}
				}
			
		});
		((JPasswordField) txt_password).setEchoChar('*');
		txt_password.setForeground(new Color(0, 128, 128));
		placeholdertext pleaceholder = new placeholdertext();
		pleaceholder.addPleaceholderStyle(txt_password);
		
	
		
		txt_password.setOpaque(false);
		txt_password.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txt_password.setColumns(10);
		txt_password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 191, 255)));
		txt_password.setBounds(109, 318, 377, 30);
		contentPanel.add(txt_password);
		
		JLabel lblNewLabel_6 = new JLabel("Usuario");
		lblNewLabel_6.setForeground(new Color(70, 130, 180));
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_6.setBounds(109, 154, 83, 30);
		contentPanel.add(lblNewLabel_6);
		

		
		txt_user = new JTextField();
		txt_user.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_user.getText().equals("¡Hola! usuario")) {
					txt_user.setText(null);
					txt_user.requestFocus();
					pleaceholder.removePleaceholderStyle(txt_user);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				 if (txt_user.getText().length()==0){
					 pleaceholder.addPleaceholderStyle(txt_user);
					 txt_user.setText("¡Hola! usuario");
				 }
			}
		});
		pleaceholder.addPleaceholderStyle(txt_user);
		txt_user.setForeground(new Color(0, 139, 139));
		txt_user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent enter) {
				if(enter.getKeyCode()==KeyEvent.VK_ENTER) {
					txt_password.requestFocusInWindow();
				}
			}
		});
		txt_user.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 191, 255)));
		txt_user.setFont(new Font("SansSerif", Font.BOLD, 14));
		txt_user.setBounds(109, 195, 377, 30);
		contentPanel.add(txt_user);
		txt_user.setColumns(10);
		txt_user.setOpaque(false);	
		
		JLabel lblNewLabel_5 = new JLabel("INICIAR SESION");
		lblNewLabel_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(156, 91, 298, 30);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Ha-100px.png"));
		lblNewLabel_4.setBounds(10, 0, 106, 109);
		contentPanel.add(lblNewLabel_4);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\cerrar-24px.png"));
		lblNewLabel_3.setBounds(852, 0, 29, 30);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\hotel-removebg-preview.png"));
		lblNewLabel_1.setBounds(583, 0, 298, 513);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_Alura_Challenge_ONE\\src\\imagen_Hotel_alura\\Blue Coral.jpg"));
		lblNewLabel.setBounds(583, 0, 298, 513);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_6_1 = new JLabel("Contraseña");
		lblNewLabel_6_1.setForeground(new Color(70, 130, 180));
		lblNewLabel_6_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_6_1.setBounds(109, 277, 106, 30);
		contentPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 206, 209)));
		lblNewLabel_2.setForeground(new Color(70, 130, 180));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\emanuel\\eclipse-workspace\\Hotel_alura_Challenge_ONE\\src\\imagen_Hotel_alura\\backgroud_Ice.jpg"));
		lblNewLabel_2.setBounds(0, 0, 625, 513);
		contentPanel.add(lblNewLabel_2);
	}

	public String getNombre() {
		return txt_user.getText();
	}
	public String getPassword() {
		return new String(txt_password.getText());
	}

}

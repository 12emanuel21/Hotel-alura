package Librery;

import java.awt.Font;

import javax.swing.JTextField;

	public class placeholdertext {
	
	public placeholdertext() {
		
	}

	public void addPleaceholderStyle(JTextField textfield) {
		Font font =	 textfield.getFont();
		font = font.deriveFont(font.BOLD);
		textfield.setFont(font);

	}
	public void removePleaceholderStyle(JTextField textfield) {
		Font font =	 textfield.getFont();
		font = font.deriveFont(font.BOLD);
		textfield.setFont(font);
		
	}

}

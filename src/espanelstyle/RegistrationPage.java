package espanelstyle;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import logicapersona.Cliente;
import logicapersona.Datasource;
import logicapersona.Utente;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Classe che Rappresenta il panello in cui va registrato un potenziale nuovo cliente 
 * @author Mohamed Marouk
 *
 */
public class RegistrationPage extends JPanel implements ActionListener, Serializable {

	private static JTextField textField;
	private static JTextField textField_1;
	private static JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private Utente user;

	/**
	 * Create the panel.
	 */
	public RegistrationPage() {
		setBackground(new Color(0, 0, 51));
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("USERNAME :");
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(176, 107, 99, 29);
		add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBackground(SystemColor.controlHighlight);
		textField.setBounds(196, 136, 241, 29);
		add(textField);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setBounds(176, 176, 99, 29);
		add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.controlHighlight);
		textField_1.setBounds(196, 375, 241, 29);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("CONFERMA PASSWORD :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setForeground(SystemColor.desktop);
		lblNewLabel_3.setBounds(176, 256, 201, 29);
		add(lblNewLabel_3);

		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.controlHighlight);
		passwordField.setBounds(196, 296, 241, 29);
		add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(SystemColor.controlHighlight);
		passwordField_1.setBounds(196, 216, 241, 29);
		add(passwordField_1);

		JLabel lblNewLabel_4 = new JLabel("INDRIZZO :");
		lblNewLabel_4.setBackground(SystemColor.desktop);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setForeground(SystemColor.desktop);
		lblNewLabel_4.setBounds(176, 336, 99, 28);
		add(lblNewLabel_4);

		JButton btnNewButton = new JButton("PROCEDI");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton.setBounds(196, 445, 99, 42);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_1.setBounds(338, 445, 99, 42);
		add(btnNewButton_1);

		btnNewButton.addActionListener(this);
		btnNewButton_1.addActionListener(this);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(RegistrationPage.class.getResource("/packagingImage/2037710.png")));
		lblNewLabel_6.setBounds(71, 21, 579, 555);
		add(lblNewLabel_6);

	}

	/**
	 * Implementazione di ogni azione presa da parte del panello 
	 * BACK(logout)
	 * PROCEDI(user panel)
	 */
	public void actionPerformed(ActionEvent e) {

		String scelta_1 = e.getActionCommand();
		String passwordText = passwordField.getText();
		String passwordText_1 = passwordField_1.getText();
		String userText_1 = textField.getText();

		if (scelta_1.equals("BACK")) {
			Home home = new Home();
			SwingUtilities.windowForComponent(this).setVisible(false);

		}

		if (scelta_1.equals("PROCEDI")) {
			if (!passwordText.equals(passwordText_1) || (passwordText.equals(""))) {
				JOptionPane.showMessageDialog(null, "Password non coincidono, Riprova !!");
			}else {

			try {
				Datasource data = new Datasource();
				if (!data.saveClient(new Cliente(userText_1, passwordText, textField_1.getText()))) {
					JOptionPane.showMessageDialog(null, "Username Già esistente !! ");
				} else {
					JFrame spedizioneFrame = new JFrame("Spedizione");
					SwingUtilities.windowForComponent(this).setVisible(false);
					spedizioneFrame.getContentPane().add(new UserPanel(userText_1));
					spedizioneFrame.setBounds(0, 0, 650, 470);
					spedizioneFrame.setLocationRelativeTo(null);
					spedizioneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					spedizioneFrame.setVisible(true);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	}
}

package espanelstyle;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import logicapersona.Admin;
import logicapersona.Cliente;
import logicapersona.Datasource;
import logicapersona.Spedizione;
import logicapersona.Utente;
import modellotabella.TablesUtil;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSeparator;

/**
 * Classe che Rappresenta il panello del login che viene effettuato sia dal cliente che dal Admin
 * @author Mohamed Marzouk
 *
 */
public class LoginPage extends JPanel implements ActionListener {

	private JTextField textField;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	private String nomePassato;
	private Utente user;

	/**
	 * Create the panel.
	 */
	public LoginPage() {
		setBackground(new Color(0, 0, 51));
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("USERNAME :");
		lblNewLabel_1.setBounds(148, 177, 110, 43);
		add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		textField = new JTextField();
		textField.setBounds(176, 231, 266, 33);
		add(textField);
		textField.setBackground(SystemColor.menu);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
		lblNewLabel_2.setBounds(148, 294, 110, 29);
		add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));

		passwordField = new JPasswordField();
		passwordField.setBounds(176, 334, 266, 33);
		add(passwordField);
		passwordField.setBackground(SystemColor.menu);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		comboBox.setBounds(259, 411, 92, 33);
		add(comboBox);
		comboBox.addItem("Admin");
		comboBox.addItem("Cliente");

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(176, 490, 121, 43);
		add(btnNewButton);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));

		btnNewButton.addActionListener(this);

		JButton btnNewButton_1 = new JButton("REGISTRARSI ?");
		btnNewButton_1.setBounds(321, 490, 127, 43);
		add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));

		btnNewButton_1.addActionListener(this);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/packagingImage/138-1387775_login-to-do-whatever-you-want-login-icon.png")));
		lblNewLabel.setBounds(112, 48, 402, 471);
		add(lblNewLabel);

	}
	
/**
 * Implementazione di ogni azione presa da parte del panello 
 * REGISTRARSI
 * LOGIN
 * 
 */
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		String scelta = e.getActionCommand();
		String sceltaCombo = (String) comboBox.getSelectedItem();
		String usernames = textField.getText();
		String passwords = passwordField.getText();

		if (scelta.equals("REGISTRARSI ?")) {
			JFrame clienteFrame = new JFrame("REGISTRAZIONE");
			SwingUtilities.windowForComponent(this).setVisible(false);
			clienteFrame.getContentPane().add(new RegistrationPage());
			clienteFrame.setBounds(0, 0, 650, 600);
			clienteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			clienteFrame.setLocationRelativeTo(null);
			clienteFrame.setVisible(true);
		}

		if (scelta.equals("LOGIN") && sceltaCombo.equals("Admin")) {
			Admin admin = new Admin();
			
			if (textField.getText().equals(admin.getUsername()) && passwordField.getText().equals(admin.getPassword())) {
				
				user = admin;
				JFrame adminFrame = new JFrame("Admin's");
				SwingUtilities.windowForComponent(this).setVisible(false);
				try {
					adminFrame.getContentPane().add(new AdminControlPanel());
					System.out.println(user.toString());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				adminFrame.setBounds(0, 0, 1000, 550);
				adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				adminFrame.setLocationRelativeTo(null);
				adminFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Login Errato, Riprova !! ");
			}

		}
		if (scelta.equals("LOGIN") && sceltaCombo.equals("Cliente")) {
			Cliente cliente;
			
			Datasource data;
			try {
				data = new Datasource();
			

			if (data.validatePassword(usernames, passwords)) {
				try {
					cliente = new Cliente(usernames, passwords, null);
					user = cliente;
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nomePassato = textField.getText();
				JFrame spedizioneFrame = new JFrame("Spedizione");
				SwingUtilities.windowForComponent(this).setVisible(false);
				spedizioneFrame.getContentPane().add(new UserPanel(nomePassato));
				spedizioneFrame.setBounds(0, 0, 650, 470);
				spedizioneFrame.setLocationRelativeTo(null);
				spedizioneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				spedizioneFrame.setVisible(true);
				System.out.println( user.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Login Errato, Riprova !! ");
			}
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	}

	public String getNomePassato() {
		return nomePassato;
	}
}

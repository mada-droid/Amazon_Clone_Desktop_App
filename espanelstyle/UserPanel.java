package espanelstyle;

import java.awt.Color;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import logicapersona.Spedizione;
import logicaspedizione.DataSpedizione;
import modellotabella.TablesUtil;



/**
 * Classe che Rappresenta il panello dello user e tutti gli elementi disponibili per esso
 * @author Mohamed Marzouk
 *
 */

public class UserPanel extends JPanel implements ActionListener {

	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private Date date;
	private String strDate;
	private String cliente;
	private TableModel tbm;

	/**
	 * Create the panel.
	 */

	
	public UserPanel() {

		setBackground(new Color(0, 0, 51));
		setLayout(null);
		date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		strDate = formatter.format(date);

		JLabel lblNewLabel_1 = new JLabel("NUOVA SPEDIZIONE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(259, 0, 155, 29);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DESTINAZIONE :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(203, 111, 115, 29);
		add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setBounds(213, 143, 264, 29);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("PESO :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(203, 172, 115, 25);
		add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(213, 196, 264, 29);
		add(textField_1);
		textField_1.setColumns(10);

		comboBox = new JComboBox();
		comboBox.addItem("Normale");
		comboBox.addItem("Assicurata");
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sceltaCombo = (String) comboBox.getSelectedItem();

				if (sceltaCombo.equals("Assicurata")) {
					textField_2.setEditable(true);
				}
				if (sceltaCombo.equals("Normale")) {
					textField_2.setEditable(false);
				}

			}
		});
		comboBox.setBounds(286, 82, 102, 29);
		add(comboBox);

		JLabel lblNewLabel_4 = new JLabel("GARANZIA ASSICURATIVA :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(203, 229, 185, 25);
		add(lblNewLabel_4);

		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.menu);
		textField_2.setBounds(213, 255, 264, 29);
		textField_2.setEditable(false);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("DATA :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(223, 389, 115, 25);
		add(lblNewLabel_5);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		textField_3.setEditable(false);
		textField_3.setText(strDate);
		textField_3.setBounds(307, 389, 81, 25);
		add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("CARICA SPEDIZIONE");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton.setBounds(240, 309, 202, 29);
		btnNewButton.addActionListener(this);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_1.setBounds(362, 349, 115, 29);
		btnNewButton_1.addActionListener(this);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("I MIEI ORDINI");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton_2.setBounds(213, 349, 125, 29);
		add(btnNewButton_2);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(new Color(102, 204, 0));
		lblNewLabel_6.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		lblNewLabel_6.setBounds(223, 42, 243, 29);
		add(lblNewLabel_6);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(345, 42, 283, 345);
				add(lblNewLabel);
				lblNewLabel.setIcon(
						new ImageIcon(UserPanel.class.getResource("/packagingImage/shipping_removed_copyrights.png")));
				
				JLabel lblNewLabel_7 = new JLabel("");
				lblNewLabel_7.setIcon(new ImageIcon(UserPanel.class.getResource("/packagingImage/shipping_removed_copyrights.png")));
				lblNewLabel_7.setBounds(23, -39, 275, 336);
				add(lblNewLabel_7);

	}

	/**
	 * Secondo Costruttore con un  parametro nella quale va passato il username del cliente
	 * @param cliente
	 */
	public UserPanel(String cliente) {
		this();
		this.cliente = cliente;
	}
	
	/**
	 * Implementazione di ogni azione presa da parte del panello 
	 * LOGOUT
	 * CARICA SPEDIZIONE
	 * I MIEI ORDINI
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		String sceltaButtone = e.getActionCommand();
		String combo = (String) comboBox.getSelectedItem();
		String ind = textField.getText();
		String peStringa = textField_1.getText();
		String vaStringa = textField_2.getText();
		boolean isNumeric_1 = peStringa.chars().allMatch( Character::isDigit );
		boolean isNumeric_2 = vaStringa.chars().allMatch( Character::isDigit );
		
		
		if (sceltaButtone.equals("LOGOUT")) {
			Home home = new Home();
			SwingUtilities.windowForComponent(this).setVisible(false);
		}
		else {
		if (sceltaButtone.equals("CARICA SPEDIZIONE")) {
			if(combo.equals("Assicurata") && (isNumeric_2) && (isNumeric_1)) {
				DataSpedizione data = new DataSpedizione();
				data.saveSpedizione(new Spedizione(cliente,combo, textField.getText(), textField_1.getText(),
						textField_2.getText(),null));
				lblNewLabel_6.setText("SPEDIZIONE CARICATA CORRETTAMENTE !");
			}
			else if (combo.equals("Normale") && (vaStringa.equals("")) && (isNumeric_1)){
				DataSpedizione data = new DataSpedizione();
				data.saveSpedizione(new Spedizione(cliente,combo, textField.getText(), textField_1.getText(),
						textField_2.getText(), null));
				lblNewLabel_6.setText("SPEDIZIONE CARICATA CORRETTAMENTE !");
			}else {
				JOptionPane.showMessageDialog(null, "Campi compilati in modo inesatto, Riprova !!");
			}
		}
		if (sceltaButtone.equals("I MIEI ORDINI")) {

			JFrame adminFrame = new JFrame("I miei ordini");
			SwingUtilities.windowForComponent(this).setVisible(false);
			adminFrame.getContentPane().add(tbm = new TableModel(cliente));
			adminFrame.setBounds(0, 0, 880, 480);
			adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			adminFrame.setLocationRelativeTo(null);
			adminFrame.setVisible(true);

		}

	}
	}

}

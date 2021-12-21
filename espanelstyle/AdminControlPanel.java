package espanelstyle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import logicapersona.Spedizione;
import logicapersona.Stato;
import logicaspedizione.CaricaSpedizioni;
import modellotabella.TablesUtil;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;



/**
 * Classe che rappresenta il panello del Admin ed implementa lo stile dei tutti gli elementi disponibili per l'Admin
 * @author Mohamed Marzouk 
 *
 */

public class AdminControlPanel extends JPanel implements ActionListener {
	

	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;
	private JTextField textField;
	protected File file = new File("");
	protected File file2 = new File(
			file.getAbsolutePath() + file.separator + "spedizionevali.txt");
	private String statoPassato;
	protected static ButtonGroup bg;
	protected TablesUtil tb;
	protected JCheckBox chckbxNewCheckBox;
	protected JCheckBox chckbxNewCheckBox_1;
	protected JCheckBox chckbxNewCheckBox_2;
	protected JCheckBox chckbxNewCheckBox_3;
	protected List<Spedizione> listCloned;
	private List<Spedizione> listSpedizioni;
	private JButton btnNewButton_3;

	/**
	 * Create the panel.
	 * 
	 * @throws FileNotFoundException
	 */
	public AdminControlPanel() throws FileNotFoundException {
		setBackground(new Color(0, 0, 51));

		btnNewButton = new JButton("LOGOUT");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(120, 463, 100, 32);
		btnNewButton.addActionListener(this);
		setLayout(null);
		add(btnNewButton);

		file = new File("");
		file2 = new File(file.getAbsolutePath() + file.separator + "src" + file.separator + "spedizionevali.txt");
		try {
			tb = new TablesUtil(file2);
			tb.getSpedzioni();
			table = new JTable(tb);
			table.setToolTipText("Seleziona Una Riga Per Modificarla");
			Stato stato = new Stato("Assicurata");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(231, 11, 739, 484);
		add(scrollPane);

		bg = new ButtonGroup();

		btnNewButton_2 = new JButton("Aggiorna Stato");
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setBounds(48, 224, 133, 32);
		btnNewButton_2.addActionListener(this);
		add(btnNewButton_2);

		chckbxNewCheckBox = new JCheckBox("RICEVUTA");
		chckbxNewCheckBox.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox.setBounds(20, 97, 118, 23);
		add(chckbxNewCheckBox);

		chckbxNewCheckBox_1 = new JCheckBox("RIMBORSO_EROGATO");
		chckbxNewCheckBox_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox_1.setBounds(20, 183, 133, 23);
		add(chckbxNewCheckBox_1);

		chckbxNewCheckBox_2 = new JCheckBox("IN_TRANSITO");
		chckbxNewCheckBox_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox_2.setBounds(102, 62, 118, 23);
		add(chckbxNewCheckBox_2);

		chckbxNewCheckBox_3 = new JCheckBox("FALLITA");
		chckbxNewCheckBox_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox_3.setBounds(102, 143, 118, 23);
		add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("IN_PREPARAZIONE", true);
		chckbxNewCheckBox_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox_4.setBounds(20, 25, 133, 23);
		add(chckbxNewCheckBox_4);

		bg.add(chckbxNewCheckBox);
		bg.add(chckbxNewCheckBox_1);
		bg.add(chckbxNewCheckBox_2);
		bg.add(chckbxNewCheckBox_3);
		bg.add(chckbxNewCheckBox_4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(AdminControlPanel.class.getResource("/packagingImage/cloud-database (1).png")));
		lblNewLabel.setBounds(6, 267, 200, 185);
		add(lblNewLabel);

		btnNewButton_3 = new JButton("Remove");
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_3.setBounds(10, 463, 100, 32);
		btnNewButton_3.addActionListener(this);
		add(btnNewButton_3);
	}

	
	/**
	 * Implementazione di ogni azione presa da parte del panello 
	 * Logout
	 * Remove
	 * Aggiorna Stato
	 * 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String scelta = e.getActionCommand();
		System.out.println(scelta);

		if (scelta.equals("LOGOUT")) {
			SwingUtilities.windowForComponent(this).setVisible(false);
			Home home = new Home();
		} else {

			int i = table.getSelectedRow();
			String strStato_1 = (String) table.getValueAt(i, 6);
			String strTipo_1 = (String) table.getValueAt(i, 1);
			String nome_rimosso = (String) table.getValueAt(i, 5);

			if (scelta.equals("Remove")) {

				if (strStato_1.equals("RICEVUTA") || (strStato_1.equals("RIMBORSO_EROGATO"))) {
					try {
						tb.removeSpedizioneCliente(nome_rimosso);
						JOptionPane.showMessageDialog(null, "Spedizione Rimossa !!");
						updateTable();

					} catch (FileNotFoundException | IndexOutOfBoundsException e1) {
					}
				} else {
					JOptionPane.showMessageDialog(null, "La Spedizione Non Si Trova In Stato Finale !!");
				}

			}

			if (scelta.equals("Aggiorna Stato")) {

				if (chckbxNewCheckBox_1.isSelected()) {
					if (strStato_1.equals("RIMBORSO_RICHIESTO")) {

						setStatoPassato(chckbxNewCheckBox_1.getText());
						tb.setCodicePassato(nome_rimosso);
						tb.setValueAt(chckbxNewCheckBox_1.getText(), i, 6);
						JOptionPane.showMessageDialog(null, "Rimborso Erogato Correttamente !!");
						try {
							updateTable();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (strStato_1.equals(chckbxNewCheckBox_1.getText())) {
						JOptionPane.showMessageDialog(null, "La Spedizione Si Trova Già In Questo Stato !!");

					} else {
						JOptionPane.showMessageDialog(null, "Reso Non Disponibile Per Tale Spedizione !!");
					}
				}

				if (chckbxNewCheckBox.isSelected()) {
					if (strStato_1.equals("IN_PREPARAZIONE")
							|| (strStato_1.equals("IN_TRANSITO") || (strStato_1.equals("FALLITA")))) {

						setStatoPassato(chckbxNewCheckBox.getText());
						tb.setCodicePassato(nome_rimosso);
						tb.setValueAt(chckbxNewCheckBox.getText(), i, 6);
						JOptionPane.showMessageDialog(null, "Stato Aggiornato !!");
						try {
							updateTable();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (strStato_1.equals(chckbxNewCheckBox.getText())) {
						JOptionPane.showMessageDialog(null, "La Spedizione Si Trova Già In Questo Stato !!");

					} else {
						JOptionPane.showMessageDialog(null, "Operazione Non Disponibile Per Tale Spedizione !!");
					}
				}

				if (chckbxNewCheckBox_2.isSelected()) {
					if (!strStato_1.equals("RIMBORSO_EROGATO") && !strStato_1.equals("RICEVUTA")) {

						setStatoPassato(chckbxNewCheckBox_2.getText());
						tb.setCodicePassato(nome_rimosso);
						tb.setValueAt(chckbxNewCheckBox_2.getText(), i, 6);
						JOptionPane.showMessageDialog(null, "Stato Aggiornato !!");
						try {
							updateTable();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (strStato_1.equals(chckbxNewCheckBox_2.getText())) {
						JOptionPane.showMessageDialog(null, "La Spedizione Si Trova Già In Questo Stato !!");

					} else {
						JOptionPane.showMessageDialog(null, "Operazione Non Disponibile Per Tale Spedizione !!");
					}
				}

				if (chckbxNewCheckBox_3.isSelected()) {
					if (!strStato_1.equals("RIMBORSO_EROGATO") && !strStato_1.equals("RICEVUTA")) {

						setStatoPassato(chckbxNewCheckBox_3.getText());
						tb.setCodicePassato(nome_rimosso);
						tb.setValueAt(chckbxNewCheckBox_3.getText(), i, 6);
						JOptionPane.showMessageDialog(null, "Stato Aggiornato !!");
						try {
							updateTable();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else if (strStato_1.equals(chckbxNewCheckBox_3.getText())) {
						JOptionPane.showMessageDialog(null, "La Spedizione Si Trova Già In Questo Stato !!");

					} else {
						JOptionPane.showMessageDialog(null, "Operazione Non Disponibile Per Tale Spedizione !!");
					}
				}

			}
		}

	}

	public String getStatoPassato() {
		return statoPassato;
	}

	public void setStatoPassato(String statoPassato) {
		this.statoPassato = statoPassato;
	}

	/**
	 * Metodo per aggiornare la tabella ogni volta viene chiamata una modifica
	 * @throws FileNotFoundException
	 */
	
	public void updateTable() throws FileNotFoundException {
		JFrame adminFrame = new JFrame("Admin's");
		SwingUtilities.windowForComponent(this).setVisible(false);
		adminFrame.getContentPane().add(new AdminControlPanel());
		adminFrame.setBounds(0, 0, 1000, 550);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.setLocationRelativeTo(null);
		adminFrame.setVisible(true);
	}

}

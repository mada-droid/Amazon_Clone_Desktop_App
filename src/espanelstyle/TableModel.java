package espanelstyle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import logicapersona.Spedizione;
import logicapersona.Stato;
import modellotabella.TablesUtil;

import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;



/**
 * Classe che Rappresenta il panello della tabella in cui il Cliente riesce a vedere e modificare i suoi spedizioni(se è possibile)
 * @author Mohamed Marzouk 
 *
 */
public class TableModel extends JPanel implements ActionListener {
	
	private String cliente;
	private JTable table;
	private TablesUtil tb;
	private JButton btnNewButton_1;
	private JCheckBox chckbxNewCheckBox;
	protected File file = new File("");
	protected File file2;

	/**
	 * 
	 * @param cliente
	 */
	public TableModel(String cliente) {
		this.cliente = cliente;
		setBackground(new Color(0, 0, 51));

		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		btnNewButton.setBounds(54, 378, 96, 38);
		btnNewButton.addActionListener(this);
		setLayout(null);
		add(btnNewButton);

		file2 = new File(file.getAbsolutePath() + file.separator + "src" + file.separator + "spedizionevali.txt");
		try {
			tb = new TablesUtil(file2);
			tb.getSpedzioniCliente(cliente);
			table = new JTable(tb);
			table.setToolTipText("Seleziona Una Spedizione Fallita");
			Stato stato = new Stato("Assicurata");
			table.setBounds(29, 11, 503, 339);
			add(table);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(207, 11, 648, 416);
		add(scrollPane);

		chckbxNewCheckBox = new JCheckBox("RICHIEDI_RIMBORSO",true);
		chckbxNewCheckBox.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		chckbxNewCheckBox.setBounds(10, 45, 157, 23);
		add(chckbxNewCheckBox);

		btnNewButton_1 = new JButton("AGGIORNA STATO SPEDIZIONE");
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		btnNewButton_1.setBounds(10, 98, 187, 38);
		btnNewButton_1.addActionListener(this);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TableModel.class.getResource("/packagingImage/cloud-database (1).png")));
		lblNewLabel.setBounds(10, 175, 187, 163);
		add(lblNewLabel);

	}
	
	/**
	 * Implementazione di ogni azione presa da parte del panello 
	 * Logout
	 * AGGIORNA STATO SPEDIZIONE
	 * 	  
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String scelta = e.getActionCommand();

		if (scelta.equals("LOGOUT")) {
			Home home = new Home();
			SwingUtilities.windowForComponent(this).setVisible(false);
		}

		if (scelta.equals("AGGIORNA STATO SPEDIZIONE")) {

			int i = table.getSelectedRow();
			String strStato = (String) table.getValueAt(i, 6);
			String strTipo = (String) table.getValueAt(i, 1);
			String firstCodice = (String) table.getValueAt(i, 5);

			if (chckbxNewCheckBox.isSelected() && strStato.equals("FALLITA") && strTipo.equals("Normale")) {
				JOptionPane.showMessageDialog(null, "Ci dispiace, La Tua Spedizione non è Assicurata !!");
			}

			else if (chckbxNewCheckBox.isSelected() && strStato.equals("FALLITA") && strTipo.equals("Assicurata")) {
				tb.setCodicePassato(firstCodice);
				tb.setValueAt("RIMBORSO_RICHIESTO", i, 6);
				JOptionPane.showMessageDialog(null, "Il Tuo Rimborso è stato Richiesto!!");
		
				JFrame adminFrame = new JFrame("I miei ordini");
				SwingUtilities.windowForComponent(this).setVisible(false);
				adminFrame.getContentPane().add(new TableModel(cliente));
				adminFrame.setBounds(0, 0, 880, 480);
				adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				adminFrame.setLocationRelativeTo(null);
				adminFrame.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Hai scelto Una Spedizione Non-Fallita !!");
			}
		}
	}

}

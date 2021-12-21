package modellotabella;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

import logicapersona.Spedizione;
import logicaspedizione.CaricaSpedizioni;

public class TablesUtil extends AbstractTableModel {

	private static List<Spedizione> listSpedizioni;
	private List<Spedizione> listSpedizioniCliente;
	private List<String> stati;
	private File file;
	private String[] headers = { "Username", "Tipo", "Destinazione", "Peso", "ValoreAssicurato", "CodiceGenerato",
			"StatoAttuale", "Data" };
	private String codicePassato;
	private Spedizione spedizione;

	public TablesUtil(File file) {
		this.file = file;
		this.listSpedizioni = new ArrayList<Spedizione>();
		this.listSpedizioniCliente = new ArrayList<Spedizione>();
		stati = new ArrayList<String>();
		stati.add("IN_TRANSITO");
		stati.add("RICEVUTA");
		stati.add("FALLITA");
		stati.add("RIMBORSO_RICHIESTO");
		stati.add("RIMBORSO_EROGATO");
	}

	@SuppressWarnings("null")
	public void getSpedzioni() throws FileNotFoundException {

		try {
			Scanner scan = new Scanner(file);

			spedizione = new Spedizione(null, null, null, null, null, null, null, null);
			while ((scan.hasNextLine())) {
				String line = scan.nextLine();
				if (line.startsWith("_")) {

					listSpedizioni.add(new Spedizione(spedizione.getNome(), spedizione.getTipo(),
							spedizione.getDestinazione(), spedizione.getPeso(), spedizione.getGaranziaAssicurativa(),
							spedizione.getCodice(), spedizione.getStato().getDefaultStato(), spedizione.getData()));

				} else {
					spedizione.setNome(line);
					spedizione.setTipo(scan.nextLine());
					spedizione.setDestinazione(scan.nextLine());
					spedizione.setPeso(scan.nextLine());
					spedizione.setGaranziaAssicurativa(scan.nextLine());
					spedizione.setCodice(scan.nextLine());
					spedizione.setStato(spedizione.getTipo(), scan.nextLine());
					spedizione.setData(scan.nextLine());
				}
			}
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Stampa Fallita");
		}
	}

	public void getSpedzioniCliente(String nome) throws FileNotFoundException {
		getSpedzioni();
		for (Spedizione spedizone : listSpedizioni)
			if (spedizone.getNome().equals(nome))
				listSpedizioniCliente.add(spedizone);
		listSpedizioni = listSpedizioniCliente;
	}

	public void removeSpedizioneCliente(String codicePassato) throws FileNotFoundException {

		List<Spedizione> temp = new ArrayList<Spedizione>();
		CaricaSpedizioni carica = new CaricaSpedizioni();
		temp = carica.getListaSpedizioniRichiestaAdmin();
		for (Spedizione spedizione : temp) {
			if (spedizione.getCodice().equals(codicePassato)) {
				temp.remove(spedizione);
				break;
			}
		}
		carica.saveSpedizioni(temp);
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public int getRowCount() {
		return listSpedizioni.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		switch (col) {

		case 0:
			return listSpedizioni.get(row).getNome();
		case 1:
			return listSpedizioni.get(row).getTipo();
		case 2:
			return listSpedizioni.get(row).getDestinazione();
		case 3:
			return listSpedizioni.get(row).getPeso();
		case 4:
			return listSpedizioni.get(row).getGaranziaAssicurativa();
		case 5:
			return listSpedizioni.get(row).getCodice();
		case 6:
			return listSpedizioni.get(row).getStato().getDefaultStato();
		case 7:
			return listSpedizioni.get(row).getData();
		}

		return "";

	}

	public int getRowShipping() {
		return listSpedizioni.size();

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		CaricaSpedizioni caricaSpedizioni = new CaricaSpedizioni();
		String validate = this.getCodicePassato();
		List<Spedizione> temp = caricaSpedizioni.getListaSpedizioniRichiestaAdmin();

		for (Spedizione spedizione : temp) {

			if (spedizione.getCodice().equals(validate)) {
				spedizione.getStato().setDefaultStato(aValue.toString());
			}
		}

		caricaSpedizioni.saveSpedizioni(temp);

	}

	@Override
	public String getColumnName(int col) {
		return headers[col];
	}

	public String getCodicePassato() {
		return codicePassato;
	}

	public void setCodicePassato(String codicePassato) {
		this.codicePassato = codicePassato;
	}

}

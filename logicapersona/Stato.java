package logicapersona;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

/**
 * Classe che serve per sapere lo stato attuale in cui si trova ogni spedizione
 * @author Mohamed Marzouk
 *
 */
public class Stato extends JComboBox<String> {
	private String defaultStato ;
	private List<String> listadiStati = new ArrayList<String>();

	public Stato(String stato) {
		if (stato.equals("Assicurata")) {
			listadiStati.add("IN_TRANSITO");
			listadiStati.add("RICEVUTA");
			listadiStati.add("FALLITA");
			listadiStati.add("RIMBORSO_RICHIESTO");
			listadiStati.add("RIMBORSO_EROGATO");
		}
		else {
			listadiStati.add("IN_TRANSITO");
			listadiStati.add("RICEVUTA");
			listadiStati.add("FALLITA");
		}
	}

	/**
	 * @return the defaultStato
	 */
	public String getDefaultStato() {
		return defaultStato;
	}

	/**
	 * @param defaultStato the defaultStato to set
	 */
	public void setDefaultStato(String defaultStato) {
		this.defaultStato = defaultStato;
	}

}

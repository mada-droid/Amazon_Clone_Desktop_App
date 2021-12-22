/**
 * 
 */
package logicapersona;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe che definisce una spedizione con tutti isuoi attribuiti
 * @author Mohamed Marzouk
 *
 */

public class Spedizione  {

	private String codice;
	private String garanziaAssicurativa;
	private String destinazione;
	private String peso;
	private String tipo;
	private String nome;
	private Stato stato;
	private String data;
	
	/**
	 * Primo Costruttore che fa settare la data
	 * @param nome
	 * @param tipo
	 * @param destinazione
	 * @param peso
	 * @param garanziaAssicurativa
	 * @param codice
	 */
	public Spedizione(String nome, String tipo, String destinazione, String peso, String garanziaAssicurativa,
			 String codice) {
		this.codice = codice;
		this.nome = nome;
		this.destinazione = destinazione;
		this.peso = peso;
		this.garanziaAssicurativa = garanziaAssicurativa;
		this.tipo = tipo;
		setStato(tipo, null);
		Date data = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate= formatter.format(data);
		this.data = strDate;
	}
	
/**
 * Secondo Costruttore che fa settare lo stato di ogni spedizione
 * @param nome
 * @param tipo
 * @param destinazione
 * @param peso
 * @param garanziaAssicurativa
 * @param codice
 * @param stato
 * @param data
 */
	public Spedizione(String nome, String tipo, String destinazione, String peso,
			String garanziaAssicurativa, String codice, String stato,String data) {
		this.codice = codice;
		this.nome = nome;
		this.destinazione = destinazione;
		this.peso = peso;
		this.garanziaAssicurativa = garanziaAssicurativa;
		this.tipo = tipo;
		this.data = data;
		setStato(tipo, stato);
			
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @return the destinazione
	 */
	public String getDestinazione() {
		return destinazione;
	}

	/**
	 * @param destinazione the destinazione to set
	 */
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}

	/**
	 * @return the peso
	 */
	public String getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(String peso) {
		this.peso = peso;
	}
/**
 * 
 * @return garanziaAssicurativa
 */
	public String getGaranziaAssicurativa() {
		return garanziaAssicurativa;
	}
/**
 * 
 * @param garanziaAssicurativa
 */
	public void setGaranziaAssicurativa(String garanziaAssicurativa) {
		this.garanziaAssicurativa = garanziaAssicurativa;
	}
/**
 * 
 * @return tipo
 */
	public String getTipo() {
		return tipo;
	}
/**
 * 
 * @param tipo
 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
/**
 * 
 * @return
 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the stato
	 */
	public Stato getStato() {
		return stato;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStato(String tipo, String stato) {
		if (tipo != null) {
			this.stato = new Stato(tipo);
			(this.stato).setDefaultStato(stato);
		} else
			this.stato = null;
	}
/**
 * Metodo Dichiarato per chiamare e settare i headers della tabella
 * @return 
 */
	public Object[] toArray() {
		Object object[] = new Object[8];

		object[0] = this.nome;
		object[1] = this.tipo;
		object[2] = this.destinazione;
		object[3] = this.peso;
		object[4] = this.garanziaAssicurativa;
		object[5] = this.codice;
		object[6] = this.stato;
		object[7] = this.data;
	
		return object;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param string 
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

}

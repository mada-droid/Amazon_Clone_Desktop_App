package logicaspedizione;

import logicapersona.Spedizione;

/**
 * Classe che Estende la classe padre Spedizione
 * @author Mohamed Marzouk
 *
 */
public class SpedizioneAssicurata extends Spedizione  {

	//private SpedizioneStatoAssicurata stato;
	
	public SpedizioneAssicurata(String nome, String destinazione, String peso, String date, String garanziaAssicurativa,
			String tipo, String codice,String data) {
		super(nome, destinazione, peso, date, garanziaAssicurativa, tipo, codice,data);
	}
/*
		public void inizializzaStato() {
			this.stato = SpedizioneStatoAssicurata.IN_PREPARAZIONE;
		}

		/**
		 * @param stato the stato to set
		 
		public void setStato(SpedizioneStatoAssicurata stato) {
			this.stato = stato;
		}
*/
			public boolean isNormal() {
				return false;
			}
	
}

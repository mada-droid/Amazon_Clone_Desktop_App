package logicaspedizione;

import logicapersona.Spedizione;

/**
 * Classe che Estende la classe padre Spedizione
 * @author Mohamed Marzouk
 *
 */
public class SpedizioneNormale extends Spedizione {

	//private SpedizioneStatoNormale stato;

	public SpedizioneNormale(String nome, String destinazione, String peso, String date, String garanziaAssicurativa,
			String tipo, String codice, String data) {
		super(nome, destinazione, peso, date, garanziaAssicurativa, tipo, codice, data);

	}

}

/**
 * 
 */
package logicapersona;

/**
 * Classe che Estende la Classe Padre(Utente) per sfruttare tutti i suoi attribuiti 
 * @author Mohamed Marzouk 
 *
 */
public class Admin extends Utente {


	public Admin() {
		super("admin", "admin");
	}

	@Override
	public String toString() {
		return "Admin []";
	}

}

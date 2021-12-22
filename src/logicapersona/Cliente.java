/**
 * 
 */
package logicapersona;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe che Estende la classe padre (Utente) aggiungendo un nuovo attribuito(L' Indrizzo)
 * @author Mohamed Marzouk
 *
 */
public class Cliente extends Utente {
	
	private String indrizzo;
	
	
	public Cliente(String username, String password, String indrizzo) throws FileNotFoundException {
		super(username, password);
		setIndrizzo(password,indrizzo);
	}
	
	

	/**
	 * @return the indrizzo
	 */
	public String getIndrizzo() {
		return indrizzo;
	}

	/**
	 * @param indrizzo the indrizzo to set
	 * @throws FileNotFoundException 
	 */
	public void setIndrizzo(String password,String indrizzo) throws FileNotFoundException {
		File file = new File("");
		File files = new File(file.getAbsolutePath() + file.separator + "src" + file.separator + "uservalidate.txt");
		
		Scanner scan = new Scanner(files);
		while(scan.hasNextLine()) {
				if(scan.nextLine().equals(password)) {
					this.indrizzo = scan.nextLine();
		}
	}
		scan.close();
	}

	@Override
	public String toString() {
		return "Cliente [indrizzo=" + indrizzo + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ "]";
	}

}

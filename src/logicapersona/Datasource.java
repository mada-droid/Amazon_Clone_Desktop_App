package logicapersona;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe per Caricare ogni singolo nuovo cliente su un file per poi potergli controlargli
 * @author Mohamed Marzouk
 *
 */
public class Datasource {

	private File file = new File("");
	private File filenew;
	private Cliente cliente ;
	private List<String> usernames;

	public Datasource() throws FileNotFoundException  {
		 cliente = new Cliente(null, null, null);
		this.filenew = new File( file.getAbsolutePath() + file.separator  +"src" +  file.separator + "uservalidate.txt");
		
		System.out.println(filenew.getAbsolutePath());
	}

	/**
	 * Metodo che carica il nuovo Cliente dopo aver controllato che il username non si trova già alla nostra database(File)
	 * @param user
	 * @return
	 */
	public boolean saveClient(Cliente user) {
		checkDublicati();
		for(int i = 0; i < usernames.size(); ++i) {
			if(usernames.get(i).equals(user.getUsername())) {
				return false;
			}
		}
		try {
			FileWriter fw = new FileWriter(this.filenew, true);
			fw.append(user.getUsername() + "\n");
			fw.append(user.getPassword() + "\n");
			fw.append(user.getIndrizzo() + "\n");
			fw.close();
			System.out.println("Inizio a deserializzare");
		} catch (IOException e) {
			System.out.println("something went wrong!!");
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Un Metodo per controllare che tale password scritto al login appartiene infatti a tale cliente che tenta di loggare 
	 * ( Potevo utilizzare i generics facendo una lista di tutti i clienti, ma ho preferito di controllare il file)
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validatePassword(String username, String password) {
		try {
			File filein = new File(file.getAbsolutePath() + file.separator  +"src" +  file.separator + "uservalidate.txt");
			System.out.println(this.filenew.getPath());
			Scanner scan = new Scanner(filein);

				
			while (scan.hasNextLine()) {
				String data = scan.nextLine();
				if (data.equals(username)) {
					String data_1 = scan.nextLine();
					if (data_1.equals(password)) {
						return true;
					} else {
						return false;
					}
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("login fallitoo");
		}
		return false;
	}
	 /**
	  * Metodo che controlla l'esistenza attuale di un username se esiste già 
	  */
	public void checkDublicati() {
		usernames = new ArrayList<String>();
		
		try {
			Scanner scan = new Scanner(this.filenew);
			while (scan.hasNextLine()) {
				int i = 2;
				String data = scan.nextLine();
				usernames.add(data);
				while(i >= 0) {
					i--;
				}
			}
			}catch (IOException e2){
				System.out.println("Registrazione Fallita !!");
			}
	}

}

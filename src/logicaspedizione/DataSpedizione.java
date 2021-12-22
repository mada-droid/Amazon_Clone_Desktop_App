package logicaspedizione;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import espanelstyle.LoginPage;
import logicapersona.Spedizione;
import logicapersona.Utente;

/**
 * Un' Altra Classe per gestire il caricamento delle spedizioni sul file(Iniziato come prova)
 * @author Mohamed Marzouk
 *
 */
public class DataSpedizione {

	private File file = new File("");
	private File filenew;
	private int count = 0;
	private String data;

	public DataSpedizione() {
		this.filenew = new File(file.getAbsolutePath() + file.separator + "src" + file.separator + "spedizionevali.txt");
	}

	public void saveSpedizione(Spedizione shiping) {

		try {
			int random_int = (int) (Math.random() * (999 - 1 + 1));
			shiping.setCodice(random_int+shiping.getNome() +"");
			shiping.setStato(shiping.getTipo(), "IN_PREPARAZIONE");
			FileWriter fw = new FileWriter(this.filenew, true);
			fw.append(shiping.getNome() + "\n");
			fw.append(shiping.getTipo() + "\n");
			fw.append(shiping.getDestinazione() + "\n");
			fw.append(shiping.getPeso() + "\n");
			fw.append(shiping.getGaranziaAssicurativa() + "\n");
			fw.append(shiping.getCodice() + "\n");
			fw.append(shiping.getStato().getDefaultStato() + "\n");
			fw.append(shiping.getData() + "\n");
			fw.append("_______________________" + "\n");
			fw.close();
			System.out.println("Inizio a scrivere sul file");
		} catch (IOException e) {
			System.out.println("something went wrong!!");
			e.printStackTrace();
		}

	}

	public int getCount() {
		return count;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

}

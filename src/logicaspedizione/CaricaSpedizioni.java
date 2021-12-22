package logicaspedizione;
import logicapersona.Spedizione;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Classe Dichiarata per caricare ogni spedizione indipendentemente sia Normale che Assicurata e caricargli su una tabella
 * @author Mohamed Marzouk
 *
 */
public class CaricaSpedizioni {
	private File source = new File("");
	public final String spedizioniSourcePath = source.getAbsolutePath() + source.separator + "src" + source.separator + "spedizionevali.txt";		

	List<Spedizione> listaSpedizioniRichiesta = new ArrayList<Spedizione>();
	String nomeCliente;

	/**
	 * Primo Costruttore va chiamato per capire che è stato il cliente a chiamare la tabella delle spedizioni(dedicate ad esso)
	 */
	public CaricaSpedizioni()  {
		setListaSpedizioniRichiesta(getListaSpedizioniRichiestaAdmin());
	}

	/**
	 * Secondo Costruttore va chiamato per capire che è stato l'Admin a chiamare la tabella delle spedizioni(tutte)
	 * @param nomeCliente
	 */
	public CaricaSpedizioni(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		setListaSpedizioniRichiesta(getListaSpedizioniRichiestaCliente());
	}

	/**
	 * Metodo va chiamato dal Admin sfruttando i generics facendo una lista in cui caricare ogni spedizione
	 * @return ogni tipo ed ogni singola spedizione
	 */
	public List<Spedizione> getListaSpedizioniRichiestaAdmin(){
		listaSpedizioniRichiesta.clear();
		try {
			File file = new File (spedizioniSourcePath);
			Scanner scan = new Scanner(file);
			Spedizione spedizione = new Spedizione(null, null, null, null, null, null, null,null);

			while ((scan.hasNextLine())) {
				String line = scan.nextLine();
				if (line.startsWith("_")) {

					listaSpedizioniRichiesta.add(new Spedizione(spedizione.getNome(), spedizione.getTipo(),
							spedizione.getDestinazione(), spedizione.getPeso(),
							spedizione.getGaranziaAssicurativa(), spedizione.getCodice(), spedizione.getStato().getDefaultStato(), spedizione.getData()));

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
			System.out.println("caricamento spedizioni Fallito");
		}
		return listaSpedizioniRichiesta;
	}

/**
 * Metodo va chiamato dal cliente 
 * @return le spedizioni dedicate al cliente
 */
	public List<Spedizione> getListaSpedizioniRichiestaCliente() {
		listaSpedizioniRichiesta.clear();
		try {
			File file = new File (spedizioniSourcePath);
			Scanner scan = new Scanner(file);
		Spedizione spedizione = new Spedizione(null,null,null,null,null,null,null,null);
			while ((scan.hasNextLine())) {
				String line = scan.nextLine();
				if (line.startsWith("_")) {

					listaSpedizioniRichiesta.add((new Spedizione(spedizione.getNome(), spedizione.getTipo(),
							spedizione.getDestinazione(), spedizione.getPeso(),
							spedizione.getGaranziaAssicurativa(), spedizione.getCodice(), spedizione.getStato().getDefaultStato(), spedizione.getData())));

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
		for (Spedizione spedizone : listaSpedizioniRichiesta)
			if (!(spedizone.getNome().equals(nomeCliente)))
				listaSpedizioniRichiesta.remove(spedizone);
		
		return listaSpedizioniRichiesta;
	}

	public void setListaSpedizioniRichiesta(List<Spedizione> listaSpedizioniRichiesta) {
		this.listaSpedizioniRichiesta = listaSpedizioniRichiesta;
	}

	/**
	 * Metodo va chiamato ogni volta il cliente carica una nuova spedizione e va a caricarla sul file
	 * @param spedizione
	 */
	public void saveSpedizione(Spedizione spedizione) {
		try {
			int random_int = (int) (Math.random() * (999 - 1 + 1));
			spedizione.setCodice(random_int+"");
			spedizione.setStato(spedizione.getTipo(), nomeCliente);
			FileWriter fw = new FileWriter(spedizioniSourcePath, true);
			fw.append(spedizione.getNome() + "\n");
			fw.append(spedizione.getTipo() + "\n");
			fw.append(spedizione.getDestinazione() + "\n");
			fw.append(spedizione.getPeso() + "\n");
			fw.append(spedizione.getGaranziaAssicurativa() + "\n");
			fw.append(spedizione.getCodice() + "\n");
			fw.append(spedizione.getStato().getDefaultStato() + "\n");
			fw.append(spedizione.getData() + "\n");
			fw.append("_______________________" + "\n");
			fw.close();
			System.out.println("spedizione aggiunta");
		} catch (IOException e) {
			System.out.println("spedizione non aggiunta!!");
			e.printStackTrace();
		}
		
	}

	/**
	 * Metodo per riscrivere tutte le spedizioni sul file
	 * @param spedizioni
	 */
	public void saveSpedizioni(List <Spedizione> spedizioni) {
		try {
			FileWriter fw = new FileWriter(spedizioniSourcePath, false);
			for(Spedizione spedizione: spedizioni)
			{
			fw.append(spedizione.getNome() + "\n");
			fw.append(spedizione.getTipo() + "\n");
			fw.append(spedizione.getDestinazione() + "\n");
			fw.append(spedizione.getPeso() + "\n");
			fw.append(spedizione.getGaranziaAssicurativa() + "\n");
			fw.append(spedizione.getCodice() + "\n");
			fw.append(spedizione.getStato().getDefaultStato() + "\n");
			fw.append(spedizione.getData() + "\n");
			fw.append("_______________________" + "\n");
			}
			fw.close();
			System.out.println("file aggiornato ");
		} catch (IOException e) {
			System.out.println("file non aggiornato!!");
			e.printStackTrace();
		}
		
	}
}


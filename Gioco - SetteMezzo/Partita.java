package settemezzo;

import java.util.*;

public class Partita {
	
	public static final String TEXT_RESET 	= "\u001B[0m";
	public static final String TEXT_CYAN 	= "\u001B[36m";

	private ArrayList<Giocatore> giocatori = new ArrayList<>(); /* Contiene i giocatori che prendono parte alla partita. Il giocatore ed il banco. */

	public Partita() {

	}

	public ArrayList<Giocatore> getGiocatori() {
		return giocatori;
	}

	/* Aggiunge il giocatore all'arraylist contente i giocatori che prendono parte alla partita */
	public void aggiungiGiocatore(Giocatore giocatore) {
		giocatori.add(giocatore);
	}

	/* Chiamato all'interno del main(). Utilizzato per stampare le carte del giocatore. */
	public StringBuilder stampaCarteGiocatore(Giocatore giocatore) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < giocatore.getCarteGiocatore().size(); i++) {
			stringBuilder.append(TEXT_CYAN + "[" + giocatore.getCarteGiocatore().get(i).getValore() + " di " 
					+ giocatore.getCarteGiocatore().get(i).getSeme() + "] " + TEXT_RESET);
		}

		stringBuilder.append("\nVALORE CARTE: " + TEXT_CYAN + "[" + giocatore.getSommaCarteGiocatore() + "]" + TEXT_RESET);

		return stringBuilder;
	}

}
package settemezzo;

import java.util.*;

public class Giocatore {

	private ArrayList<Carta> carteGiocatore = new ArrayList<>(); /* Conterrà carte generate randomicamente o "tirate" ed assegnate al giocatore */
	private double sommaCarteGiocatore = 0; /* Contiene la somma delle carte tirate al giocatore */
	private boolean sballato = false;

	public Giocatore() {

	}

	public ArrayList<Carta> getCarteGiocatore() {
		return carteGiocatore;
	}

	public double getSommaCarteGiocatore() {
		return sommaCarteGiocatore;
	}

	public boolean isSballato() {
		return sballato;
	}

	/* Aggiunge la carta generata nel main() all'arraylist carteGiocatore. Esegue poi l'opportuna addizione del valore della carta. */
	public void tiraCarta(Carta carta) {
		
		carteGiocatore.add(carta);
		
		if (carta.getValore() == 10 && carta.getSeme() == "Denari") // In caso di matta.
		{
			sommaCarteGiocatore = 7.5;
		}
		else if (carta.getValore() > 0 && carta.getValore() <= 7) 	// In caso di carta con valore tra 1 e 7.
		{
			sommaCarteGiocatore += carta.getValore();
		}
		else if (carta.getValore() > 7 && carta.getValore() <= 10) 	// In caso di mezza figura.
		{
			sommaCarteGiocatore += 0.5;
		}
		
		checkIfSballato();
	}

	/* Viene richiamato ogni volta che viene "tirata" una carta al giocatore. Controlla se quest'ultimo ha sballato. */
	public void checkIfSballato() {
		if (sommaCarteGiocatore > 7.5)
		{
			this.sballato = true;
		}
		else
		{
			this.sballato = false;
		}
	}

}
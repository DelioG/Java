package settemezzo;

import java.util.*;

public class Mazzo {
	
	private Random random = new Random();
	private ArrayList<Carta> mazzo = new ArrayList<>(40); /* Inizializza l'arraylist contenente le 40 carte generate dal metodo generaMazzo(). */
	private ArrayList<String> semi = new ArrayList<>(Arrays.asList("Bastoni", "Coppe", "Denari", "Spade")); /* Semi disponibili. */

	public Mazzo() {

	}

	public ArrayList<Carta> getMazzo() {
		return mazzo;
	}

	/* Genera il mazzo di 40 carte. 10 carte per ogni seme. Le carte vanno da 1 al 10. */
	public void generaMazzo()
	{
		for (int i = 1; i <= 10; i++)
		{
			Carta cartaBastoni 	= new Carta(i, "Bastoni");
			Carta cartaCoppe 	= new Carta(i, "Coppe");
			Carta cartaDenari	= new Carta(i, "Denari");
			Carta cartaSpade 	= new Carta(i, "Spade");
			mazzo.add(cartaBastoni);
			mazzo.add(cartaCoppe);
			mazzo.add(cartaDenari);
			mazzo.add(cartaSpade);
		}
	}
	
	/* Genera una carta randomica. Una volta generata viene rimossa dal mazzo. Viene richiamato nel main(). */
	public Carta generaCartaRandom()
	{
		Carta carta = new Carta();						// Inizializzo una carta con valore 0, alla quale assegnerò il valore più avanti.
		String seme = null;
		int valore = 0;
		boolean generato = false;						// Utilizzato per la condizione del while.
		
		while (generato != true)
		{
			valore = random.nextInt(10) + 1;			// Genera un valore randomico per la carta.
			int semeTmp = random.nextInt(semi.size());	// Genera un valore compreso tra 1 e 4 per il seme.
			seme = semi.get(semeTmp);					// Prende randomicamente un seme da quelli disponibili utilizzando l'intero generato prima.

			for (int i = 0; i < mazzo.size(); i++) 		// Controlla se nel mazzo è ancora disponibile la carta generata.
			{
				if (mazzo.get(i).getValore() == valore && mazzo.get(i).getSeme() == seme)	// Se la carta generata è presente nel mazzo.
				{
					carta.setValore(valore);			// Assegno all'oggetto Carta il valore generato.
					carta.setSeme(seme);				// Assegno all'oggetto Carta il seme generato.
					mazzo.remove(mazzo.get(i));			// Rimuovo la carta generata dal mazzo delle carte disponibili.
					generato = true;					// Chiudo il ciclo while.
				}
			}
		}

		return carta;
	}

}
package settemezzo;

import java.util.*;

public class Starter {

	public static void main(String[] args) {
		
		int scelta = 0; 							// Utilizzato per lo switch all'interno del while.
		Scanner scanner = new Scanner(System.in);
		Partita partita = new Partita();
		Mazzo mazzo = new Mazzo();
		Giocatore giocatore = new Giocatore();
		Giocatore banco = new Giocatore();

		partita.aggiungiGiocatore(giocatore);
		partita.aggiungiGiocatore(banco);
		mazzo.generaMazzo();
		
		/* Inzia la partita e tira la prima carta al giocatore. */
		System.out.println("--------------------------------------------------");
		System.out.println("       		PARTITA INIZIATA                      ");
		System.out.println("--------------------------------------------------");
		giocatore.tiraCarta(mazzo.generaCartaRandom());
		System.out.println("\nLE TUE CARTE: " + partita.stampaCarteGiocatore(giocatore));

		/* Avvio il ciclo while sino a quando il giocatore non ha sballato */
		ciclowhile: 
		while (!partita.getGiocatori().get(0).isSballato()) 
		{
			System.out.print("\nDIGITA 1 PER STARE, 2 PER TIRARE: ");
			scelta = scanner.nextInt();

			switch (scelta) {
				case 1: 																				// Azione Tira Carta.
					giocatore.tiraCarta(mazzo.generaCartaRandom());
					System.out.println("\nLE TUE CARTE: " + partita.stampaCarteGiocatore(giocatore));
					break;
				case 2:																					// Azione Stai.
					break ciclowhile;
				default:
					System.out.println("\nERRORE GENERICO!");
					System.exit(0);
			}
		}

		/* Controllo se il giocatore ha "sballato". Nel caso non avesse "sballato" gioca il banco. */
		if (giocatore.isSballato()) 
		{
			System.out.println("\nHAI SBALLATO!");
		} 
		else 
		{
			System.out.println("\n--------------------------------------------------");
			System.out.println("    		GIOCA IL BANCO                 		    ");
			System.out.println("--------------------------------------------------  ");

			banco.tiraCarta(mazzo.generaCartaRandom());
			System.out.println("\nCARTE BANCO : " + partita.stampaCarteGiocatore(banco));

			/* Questa è una sorta di "intelligenza artificiale del banco. Continua il ciclo fin quando il banco non ha "sballato" o vinto. */
			ciclowhilebanco:
			while (!partita.getGiocatori().get(1).isSballato())
			{
				if (banco.getSommaCarteGiocatore() == giocatore.getSommaCarteGiocatore() && banco.getSommaCarteGiocatore() == 7.5)
				{
					System.out.println("\nPAREGGIO!	");
					break ciclowhilebanco;
				}
				else if (banco.getSommaCarteGiocatore() > giocatore.getSommaCarteGiocatore() && banco.getSommaCarteGiocatore() <= 7.5)
				{
					System.out.println("\nHAI PERSO! IL BANCO HA VINTO...");
					break ciclowhilebanco;
				}
				else
				{
					while (banco.getSommaCarteGiocatore() <= giocatore.getSommaCarteGiocatore()) {
						banco.tiraCarta(mazzo.generaCartaRandom());
						System.out.println("\nCARTE BANCO : " + partita.stampaCarteGiocatore(banco));
					}
				}
			}

			if (banco.isSballato()) /* Controllo se il banco ha sballato. */
			{
				System.out.println("\nHAI VINTO! IL BANCO HA SBALLATO...");
			}
		}

	} // main()
}
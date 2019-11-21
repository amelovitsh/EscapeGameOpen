package escapeGame;

import java.util.Scanner;

/**
 * <b>Comparateur est la classe qui compare combinaison et propositions </b>
 * @see Joueur
 * @see COrdi
 * @author Pulsar
 * @version 1.0
 */

public class Duel {

	LecturConfig appProps = new LecturConfig();
	int xChiffrComb = appProps.getPropertyXchiffrComb();
	int nbrEssai = appProps.getPropertyNbrEssai();
	boolean moDev = appProps.getPropertyMoDev();
	int essai =0;
	int tabMin[]= new int[xChiffrComb];
	int tabMax[]= new int[xChiffrComb];
	int pivot[]= new int[xChiffrComb];
	int [] combinaisonSecretOrdi = new int[xChiffrComb];
	Scanner clavier = new Scanner(System.in);
	boolean challengerModOn;
	boolean deffenseurModOn;
	
	
	
	/** 
	 * Mode duel Ordi et Joueur tentent de deviner la combinaison de l'autre à tour de rôle
	 * @see Comparateur
     */
	public void duel() {
	int tour = nbrEssai*2;
	while(tour>0) {
		
		int pairImpair = tour %2;
		
		if(pairImpair==0) {
			System.out.print("\nchallenger\n");
			Ordi OrdiEscape = new Ordi();
			combinaisonSecretOrdi = OrdiEscape.generCombO();
			 challengerModOn= true;
				while(challengerModOn && essai<nbrEssai) {
					challengerModOn= false;
					Challenger chalDuel = new Challenger();
					chalDuel.propoJ();
					tour--;
				}
				/*if(challengerModOn==false && essai<=nbrEssai) {
					System.out.print(challengerModOn);
					System.out.print("\nBravo! Vous avez trouvé la bonne combinaison");
				}
				else {
				System.out.print("\nNombre d'essais maximum atteint");
			}*/
		}
		else {
			System.out.print("\ndeffenseur\n");
			Joueur combinaisonAdevinerDuJoueur = new Joueur();
			combinaisonAdevinerDuJoueur.demandCombJ();
			
			for(int i = 0; i <= xChiffrComb-1; i++) {

				tabMin[i] = 0;
				tabMax[i] = 9;
				pivot[i] = (tabMax[i]+tabMin[i])/2+1;
				System.out.print(pivot[i]);
				}
			
			deffenseurModOn= true;
			while(deffenseurModOn && essai<nbrEssai) {
				deffenseurModOn= false;	
				Deffenseur deffDuel = new Deffenseur();
				deffDuel.recherchDico();
				tour--;
			}
			if(deffenseurModOn==false && essai<=nbrEssai) {
				System.out.print("\nCombinaison trouvé!");
			}
			else {
			System.out.print("\nNombre d'essais maximum atteint");
			}
		}
		}
	}
}

	

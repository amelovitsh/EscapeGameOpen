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
	boolean duelChalModOn;
	boolean duelDefModOn;
	Challenger challengerC;
	Deffenseur deffenseurD;
	
	
	/** 
	 * Mode duel Ordi et Joueur tentent de deviner la combinaison de l'autre à tour de rôle
	 * @see Comparateur
     */
	public void duel() {
		
		challengerC= new Challenger();
		deffenseurD= new Deffenseur();
		duelChalModOn= true;
		duelDefModOn= true;
		Ordi OrdiEscape = new Ordi();
		int combinaisonSecretOrdi[] = OrdiEscape.generationSecreteCombinaisonOrdinateur();
		System.out.print("\nTour Humain: Rentrer votre combinaison secrète\n");
		int [] combinaisonSecretJoueur = Utilitaires.demandCombJ();
		System.out.print("Voici la combinaison secrète que l'ordinateur doit tenter de trouver:");
		for(int i:combinaisonSecretJoueur) {
			System.out.print(i);
		}
		for(int i = 0; i <= xChiffrComb-1; i++) {
			deffenseurD.tabMin[i] = 0;
			deffenseurD.tabMax[i] = 9;
			}
		
		while((duelChalModOn && duelDefModOn)) {
			duelChalModOn= false;
			duelDefModOn= false;
			System.out.print("\nA vous de deviner la combinaison de l'ordinateur:");
			duelChalModOn = challengerC.propoJ();
			
			
			System.out.print("\nTour ordinateur: A l'ordi de deviner la combi du joueur\n");
			
			for(int i = 0; i <= xChiffrComb-1; i++) {
			
				deffenseurD.pivot[i] = (deffenseurD.tabMax[i]+deffenseurD.tabMin[i])/2+1;
				System.out.print(deffenseurD.pivot[i]);
				}
			
			
			duelDefModOn = deffenseurD.recherchDico();
		}
	}
}

	

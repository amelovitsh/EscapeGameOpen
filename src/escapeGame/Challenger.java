package escapeGame;

import java.util.Scanner;

/**
 * <b>Comparateur est la classe qui compare combinaison et propositions </b>
 * @see Joueur
 * @see COrdi
 * @author Pulsar
 * @version 1.0
 */

public class Challenger {

	LecturConfig appProps = new LecturConfig();
	int xChiffrComb = appProps.getPropertyXchiffrComb();
	int nbrEssai = appProps.getPropertyNbrEssai();
	boolean moDev = appProps.getPropertyMoDev();
	int essai =0;
	char indicationJ[] = new char[xChiffrComb];
	int [] combinaisonSecretOrdi = new int[xChiffrComb];
	private String indicSign;
	Scanner clavier = new Scanner(System.in);
	boolean challengerModOn;
	
	
	
	
	/** 
	 * propoJ donne nouvelle combi en fonction de la proposition du joueur.
	 * @see Ordi
	 * @see Comparateur
     */
	public void propoJ() {
		
		System.out.print("\nA vous de deviner la combinaison de l'ordinateur:");

		int []combinaisonSecretJoueur = Utilitaires.demandCombJ();
				
				for (int i = 0; i < combinaisonSecretJoueur.length; i++) {
					
					if(combinaisonSecretJoueur[i]==combinaisonSecretOrdi[i]) {
						
						System.out.print("=");
					}
					
					else if (combinaisonSecretOrdi[i]<combinaisonSecretJoueur[i]){
						System.out.print("-");
						challengerModOn= true;
					}
					else if (combinaisonSecretOrdi[i]>combinaisonSecretJoueur[i]){
						System.out.print("+");
						challengerModOn= true;
					}	
				}
				essai++;
			}
	/** 
	 * Mode challenger système donne indication au joueur pour qu'il tente de deviner comb Ordi 
	 * @see Joueur
	 * @see Ordi
	 * @see Comparateur
     */
	public void challenger() {
		Ordi OrdiEscape = new Ordi();
		combinaisonSecretOrdi = OrdiEscape.generCombO();
		 challengerModOn= true;
			while(challengerModOn && essai<nbrEssai) {
				challengerModOn= false;
				propoJ();
			}
			if(challengerModOn==false && essai<=nbrEssai) {
				System.out.print("\nBravo! Vous avez trouvé la bonne combinaison");
			}
			else {
			System.out.print("\nNombre d'essais maximum atteint");
		}
			}
	

}

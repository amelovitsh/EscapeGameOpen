package game;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import configuration.LecturConfig;
import configuration.Utilitaires;
import escapeGame.CombinaisonAléatoirOrdi;

/**
 * <b>Challenger est la classe qui compare la combinaison aléatoire de l'ordinateur et la proposition du joueur </b>
 * @see Joueur
 * @see CombinaisonAléatoirOrdi
 * @author Pulsar
 * @version 1.0
 */

public class Challenger {
	//static Logger logger = LogManager.getLogger(Challenger.class);
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
	
	public boolean propoJ(int[]combinaisonSecretOrdi) {
		this.combinaisonSecretOrdi=combinaisonSecretOrdi;
		return propoJ();
	}
		
	
	
	/** 
	 * propoJ donne nouvelle combi en fonction de la proposition du joueur.
	 * @see CombinaisonAléatoirOrdi
	 * @see Comparateur
     */
	public boolean propoJ() {
		//logger.info("msg d'information:methode propoJ ligne 42");
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
				return challengerModOn;
			}
	/** 
	 * Mode challenger système donne indication au joueur pour qu'il tente de deviner comb Ordi 
	 * @see CombinaisonAléatoirOrdi
	 * @see Comparateur
     */
	public void challenger() {
		CombinaisonAléatoirOrdi ordiescape = new CombinaisonAléatoirOrdi();
		combinaisonSecretOrdi = ordiescape.generationSecreteCombinaisonOrdinateur();
		challengerModOn= true;
		System.out.print("\nA vous de deviner la combinaison de l'ordinateur:");

			while(challengerModOn && essai<nbrEssai) {
				challengerModOn= false;
				propoJ();
				System.out.print("\nRéessayez une nouvelle combinaison:");
			}
			if(challengerModOn==false && essai<=nbrEssai) {
				System.out.print("\nBravo! Vous avez trouvé la bonne combinaison");
			}
			else {
			System.out.print("\nNombre d'essais maximum atteint");
		}
			}
	

}

package escapeGame;
import java.util.Scanner;

import configuration.LecturConfig;

/**
 * <b>Ordi est la classe qui génère et stock la combinaison de l'ordi </b>
 * @author Pulsar
 * @version 1.0
 */

public class CombinaisonAléatoirOrdi {
	
	static LecturConfig appProps = new LecturConfig();
	static int xChiffrComb = appProps.getPropertyXchiffrComb();
	static boolean moDev = appProps.getPropertyMoDev();
	static int combinaisonO[] = new int[xChiffrComb];
	static int  a = 1;
	Scanner clavier = new Scanner(System.in);
 	
	/** 
	 * Génere  une combinaison aléatoire
     * @return combinaisonO
     */
	public  int [] generationSecreteCombinaisonOrdinateur(){
		
		for(int i = 1; i <= xChiffrComb; i++)
		{
			int nombreAleatoire = (int)(Math.random() * ((9) + 1));
			
			combinaisonO[i-1] = nombreAleatoire;	
			
			}
		if(moDev==true) {
			System.out.print("Combinaison  secrète ordi:");
			for(int i:combinaisonO) {
				System.out.print(i);
			}
		}
		return combinaisonO;
		}
}
	


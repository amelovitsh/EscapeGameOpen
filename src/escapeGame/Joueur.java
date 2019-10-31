package escapeGame;
import java.util.Scanner;

/**
 * <b>Joueur est la classe qui réccupère et stock la combinaison du joueur </b>
 * @author Pulsar
 * @version 1.0
 */

public class Joueur {
	
	static int  xChiffrComb = 4;
	static int combinaisonJ[] = new int[xChiffrComb];
	static int  a = 1;
	private String combX;
	Scanner clavier = new Scanner(System.in);
	
	
	/** 
	 * Reccupère la combinaison du joueur
     * @return combinaisonJ
     */
	public int [] demandCombJ(){
		System.out.println("\nChoisissez les "+ xChiffrComb + " chiffres de votre combinaison");
		this.combX = clavier.nextLine();
		for(int i = 1; i <= xChiffrComb; i++)
		{
			int combXint = Integer.parseInt(combX.substring(i-1, i));
			combinaisonJ[i-1] = combXint;	
		}
		return combinaisonJ;
		}
		
}
	

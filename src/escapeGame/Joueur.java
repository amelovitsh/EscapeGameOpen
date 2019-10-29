package escapeGame;
import java.util.Scanner;

public class Joueur {
	
	static int  xChiffrComb = 4;
	static int combinaisonJ[] = new int[xChiffrComb];
	static int  a = 1;
	private String combX;
	Scanner clavier = new Scanner(System.in);
	

	public int getXchiffrComb() {
		return xChiffrComb;
	}
	public void setXchiffrComb(int xchiffrComb) {
		this.xChiffrComb = xchiffrComb;
	} 
	
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
	

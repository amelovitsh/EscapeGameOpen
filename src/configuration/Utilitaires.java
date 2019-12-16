package configuration;

import java.util.Scanner;

public class Utilitaires {
	static LecturConfig appProps = new LecturConfig();
	static int xChiffrComb = appProps.getPropertyXchiffrComb();
	int nbrEssai = appProps.getPropertyNbrEssai();
	boolean moDev = appProps.getPropertyMoDev();
	static char indicationJ[] = new char[xChiffrComb];
	int [] combinaisonSecretOrdi = new int[xChiffrComb];
	private static String indicSign;
	static Scanner clavier;
	static int  a = 1;
	static private String combX;
	static int combinaisonJ[] = new int[xChiffrComb];
	

	/** 
	 * Stock dans un tableau les indications (+-=) que donne le joueur
     * @return indicationJ
     */
	public static char [] stockIndication(){
		clavier = new Scanner(System.in);
		System.out.println("\nMerci d'indiquer pour chaque chiffre de la combinaison proposé si le chiffre à deviner est :\nplus grand(+)\nplus petit(-)\négale(=)");
		try {
			indicSign = clavier.nextLine();
		for(int i = 1; i <= xChiffrComb; i++)
		{
			char elmtSign = indicSign.charAt(i-1);
			indicationJ[i-1] = elmtSign;
		}}
		catch(Exception e){
			for(int i = 1; i <= xChiffrComb; i++)
			{
				indicationJ[i-1] = '-';
			}
		}
		
		return indicationJ;
		}
	
	
	/** 
	 * Reccupère la combinaison du joueur
     * @return combinaisonJ
     */
		static public int [] demandCombJ(){
		clavier = new Scanner(System.in);
		//System.out.println("\nChoisissez les "+ xChiffrComb + " chiffres de votre combinaison");
		try{
			combX = clavier.nextLine();
			for(int i = 1; i <= xChiffrComb; i++)
			{
				int combXint = Integer.parseInt(combX.substring(i-1, i));
				combinaisonJ[i-1] = combXint;	
			}
		}
		catch(Exception e){
			System.out.println("\nChoisissez une combinaison à "+ xChiffrComb + " chiffres (combinaison par defaut 5555)");
			for(int i = 1; i <= xChiffrComb; i++)
			{
				combinaisonJ[i-1] = 5;	
			}
		}
		
		return combinaisonJ;
		}

}

package escapeGame;

import java.util.Scanner;

/**
 * <b>Comparateur est la classe qui compare combinaison et propositions </b>
 * @see Joueur
 * @see COrdi
 * @author Pulsar
 * @version 1.0
 */

public class Comparateur2 {
	static int  xChiffrComb = 4;
	static int nbrEssai =2;
	int essai =0;
	static char indicationJ[] = new char[xChiffrComb];
	static int nvlProposition[]= new int[xChiffrComb];
	int tabMin[]= new int[xChiffrComb];
	int tabMax[]= new int[xChiffrComb];
	int pivot[]= new int[xChiffrComb];
	int  a = 1;
	int equalrecherchDico=0;
	int equalChallenger = 0;
	private String indicSign;
	Scanner clavier = new Scanner(System.in);
	
	
	
	/** 
	 * Stock dans un tableau les indications (+-=) que donne le joueur
     * @return indicationJ
     */
	public char [] stockIndication(){
		System.out.println("\nMerci d'indiquer pour chaque chiffre de la combinaison proposé si le chiffre à deviner est :\nplus grand(+)\nplus petit(-)\négale(=)");
		this.indicSign = clavier.nextLine();
		for(int i = 1; i <= xChiffrComb; i++)
		{
			char elmtSign = indicSign.charAt(i-1);
			indicationJ[i-1] = elmtSign;
		}
		
		return indicationJ;
		}
	/**
	 * Methode extraite de recherche dicho
	 * 
	 */
	public void methodExtraite() {
		while (equalrecherchDico < indicationJ.length){
			
			equalrecherchDico = 0;
			stockIndication();
			
			for(int i=0; i< indicationJ.length; i++) {
				
				if(indicationJ[i] == '=') {
					
					equalrecherchDico++;	
				}
				else if(indicationJ[i] == '+'){
					 
					 tabMin[i] = pivot[i] +1;
				}
				else if(indicationJ[i] == '-'){
					 
					 tabMax[i] = pivot[i]-1;
					
				}
				pivot[i] = ((tabMin[i]+tabMax[i])/2)+1;
				nvlProposition[i] = pivot[i];
			}
		}
	}
	/** 
	 * propoJ donne nouvelle proposition 
     */
	public void recherchDico(){ 
		
		for(int i = 0; i <= xChiffrComb-1; i++) {

			tabMin[i] = 0;
			tabMax[i] = 9;
			pivot[i] = (tabMax[i]+tabMin[i])/2+1;
			System.out.print(pivot[i]);
			}
		
		methodExtraite();
	
		/*while (equalrecherchDico < indicationJ.length){
			
			equalrecherchDico = 0;
			stockIndication();
			
			for(int i=0; i< indicationJ.length; i++) {
				
				if(indicationJ[i] == '=') {
					
					equalrecherchDico++;	
				}
				else if(indicationJ[i] == '+'){
					 
					 tabMin[i] = pivot[i] +1;
				}
				else if(indicationJ[i] == '-'){
					 
					 tabMax[i] = pivot[i]-1;
					
				}
				pivot[i] = ((tabMin[i]+tabMax[i])/2)+1;
				nvlProposition[i] = pivot[i];
			}*/
			
			essai++;
			System.out.print(essai);
			System.out.print(nbrEssai+"\n");
			if(equalrecherchDico != indicationJ.length & essai == nbrEssai) {
				
			System.out.print("\nNombre d'essais maximum atteint");
					
			}
				if(equalrecherchDico != indicationJ.length & essai != nbrEssai) {
					for (int u = 0; u < nvlProposition.length; u++) {
						if(nvlProposition[u]>=1 & nvlProposition[u]<9) {
							
				        System.out.print(nvlProposition[u]); 
						}
						else if(nvlProposition[u]>9) {
							nvlProposition[u]=9;
							System.out.print(nvlProposition[u]);
							}
					}
				}
	//}
			
			if(equalrecherchDico == indicationJ.length) {
				System.out.println("Votre combinaison est");
			
				for (int u = 0; u < nvlProposition.length; u++) {
					if(nvlProposition[u]>=1 & nvlProposition[u]<9) {
			        System.out.print(nvlProposition[u]); 
					}
					else if(nvlProposition[u]>9) {
						nvlProposition[u]=9;
						System.out.print(nvlProposition[u]);
						}
				}
			}
	}
	
	/** 
	 * Mode deffenseur Ordi tente de donner combinaison joueur selon recherche dichotomique
	 * @see Joueur
	 * @see Comparateur
     * @return indicationJ
     */
	public void deffenseur(){ 
		Joueur Jtest = new Joueur();
		int []tabJ = Jtest.demandCombJ();
		recherchDico();
	}
	
	/** 
	 * propoJ donne nouvelle combi en fonction de la proposition du joueur.
	 * @see Ordi
	 * @see Comparateur
     */
	public void propoJ() {
		
		Ordi OrdiEscape = new Ordi();
		int [] tabO = OrdiEscape.generCombO();
		
		System.out.print("\nA vous de deviner la combinaison de l'ordinateur:");
		Joueur Jtest = new Joueur();
		int []tabJ = Jtest.demandCombJ();
		
			while(equalChallenger != tabJ.length & essai != nbrEssai) {
				
				for (int i = 0; i < tabJ.length; i++) {
						
					if(tabJ[i]==tabO[i]) {
						
						System.out.print("=");
						equalChallenger++;
					}
					
					else if (tabO[i]<tabJ[i]){
						System.out.print("-");
					}
					else if (tabO[i]>tabJ[i]){
						System.out.print("+");
					}	
				}
				//essai++;
				//System.out.print(essai);
			
				if(equalChallenger != tabJ.length) {
					
					equalChallenger = 0;
					//Jtest.demandCombJ();
					}
				
					else if(equalChallenger == tabJ.length){
						System.out.print("\nBravo! Vous avez trouvé la bonne combinaison");
					}
				essai++;
				System.out.print(essai);
			}
			}
	
	/** 
	 * Mode challenger système donne indication au joueur pour qu'il tente de deviner comb Ordi 
	 * @see Joueur
	 * @see Ordi
	 * @see Comparateur
     */
	public void challenger() {
	
			while(equalChallenger != xChiffrComb & essai != nbrEssai) {
				propoJ();
			}
			if(essai == nbrEssai) {
			System.out.print("\nNombre d'essais maximum atteint");
		}
			}
	
	/** 
	 * 
	 * @see Comparateur
     */
	
	/** 
	 * Mode duel Ordi et Joueur tentent de deviner la combinaison de l'autre à tour de rôle
	 * @see Comparateur
     */
	public void duel() {
	int tour = nbrEssai;
	
	while(tour>0) {
		
		int pairImpair = tour %2;
		
		if(pairImpair==0) {
			System.out.print("\nchallenger\n");
			while(equalChallenger != xChiffrComb & essai != nbrEssai) {
				propoJ();
				tour=tour-1/2;
			}
			if(essai == nbrEssai) {
			System.out.print("\nNombre d'essais maximum atteint");
			}
		}
			
		
		else {
			System.out.print("\ndeffenseur\n");
			/*while(equalChallenger != xChiffrComb & essai != nbrEssai) {
				methodExtraite();
				tour=tour-1/2;
			}
			if(essai == nbrEssai) {
			System.out.print("\nNombre d'essais maximum atteint");
			}*/
		}	
		
	}
	}
}

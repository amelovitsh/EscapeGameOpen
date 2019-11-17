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
	static int  a = 1;
	int equals = 0;
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
	 * propoJ donne nouvelle proposition 
     */
	public void propoJ(){ 
		
		for(int i = 0; i <= xChiffrComb-1; i++) {

		tabMin[i] = 0;
		tabMax[i] = 9;
		pivot[i] = (tabMax[i]+tabMin[i])/2+1;
		System.out.print(pivot[i]);
		}
	
	while (equals < indicationJ.length){
		
			equals = 0;
			stockIndication();
			
			for(int i=0; i< indicationJ.length; i++) {
				
				if(indicationJ[i] == '=') {
					
					equals++;	
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
			
			essai++;
			System.out.print(essai);
			System.out.print(nbrEssai+"\n");
			if(equals != indicationJ.length & essai == nbrEssai) {
				
			System.out.print("\nNombre d'essais maximum atteint");
					
			}
				if(equals != indicationJ.length & essai != nbrEssai) {
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
			
			if(equals == indicationJ.length) {
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
		propoJ();
	}
	
	/** 
	 * recherchDico donne nouvelle combi en fonction de la proposition du joueur.
	 * @see Ordi
	 * @see Comparateur
     */
	public void recherchDico() {
		
		Ordi OrdiEscape = new Ordi();
		int [] tabO = OrdiEscape.generCombO();
		
		System.out.print("\nA vous de deviner la combinaison de l'ordinateur:");
		Joueur Jtest = new Joueur();
		int []tabJ = Jtest.demandCombJ();
		
			while(equals != tabJ.length & essai != nbrEssai) {
				
				for (int i = 0; i < tabJ.length; i++) {
						
					if(tabJ[i]==tabO[i]) {
						
						System.out.print("=");
						equals++;
					}
					
					else if (tabO[i]<tabJ[i]){
						System.out.print("-");
					}
					else if (tabO[i]>tabJ[i]){
						System.out.print("+");
					}	
				}
				essai++;
			
				if(equals != tabJ.length) {
					
					equals = 0;
					//Jtest.demandCombJ();
					}
				
					else if(equals == tabJ.length){
						System.out.print("\nBravo! Vous avez trouvé la bonne combinaison");
					}
			}
			}
	
	/** 
	 * Mode challenger système donne indication au joueur pour qu'il tente de deviner comb Ordi 
	 * @see Joueur
	 * @see Ordi
	 * @see Comparateur
     */
	public void challenger() {
		
		int equals = 0;
	
			while(equals != xChiffrComb & essai != nbrEssai) {
				recherchDico();
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
			recherchDico();
			tour--;
		}
		else {
			System.out.print("\ndeffenseur\n");
			propoJ();
			tour--;
		}
		}	
		
	}	
}

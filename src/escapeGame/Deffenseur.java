package escapeGame;

import java.util.Scanner;

/**
 * <b>Comparateur est la classe qui compare combinaison et propositions </b>
 * @see Joueur
 * @see COrdi
 * @author Pulsar
 * @version 1.0
 */

public class Deffenseur {

	LecturConfig appProps = new LecturConfig();
	int xChiffrComb = appProps.getPropertyXchiffrComb();
	int nbrEssai = appProps.getPropertyNbrEssai();
	boolean moDev = appProps.getPropertyMoDev();
	int essai =0;
	int nvlProposition[]= new int[xChiffrComb];
	int tabMin[]= new int[xChiffrComb];
	int tabMax[]= new int[xChiffrComb];
	int pivot[]= new int[xChiffrComb];
	int equalrecherchDico=0;
	boolean deffenseurModOn;
	
	
	
	
	/**
	 * Methode recherchDico algorithme selon le principe de recherche dichotomique
	 * 
	 */
	public boolean recherchDico() {
		 
		char indicationJ[]= Utilitaires.stockIndication();
			for(int i=0; i< indicationJ.length; i++) {
				
				if(indicationJ[i] == '=') {
				nvlProposition[i] = pivot[i];
				}
				else if(indicationJ[i] == '+'){
 
					 tabMin[i] = pivot[i] +1;
					 deffenseurModOn= true;
					 pivot[i] = ((tabMin[i]+tabMax[i])/2);
					 nvlProposition[i] = pivot[i];
				}
				else if(indicationJ[i] == '-'){

					 tabMax[i] = pivot[i]-1;
					 deffenseurModOn= true;
					 pivot[i] = ((tabMin[i]+tabMax[i])/2);
					 nvlProposition[i] = pivot[i];
					
				}
				
				if(nvlProposition[i]>=1 & nvlProposition[i]<=9) {
					
			       System.out.print(nvlProposition[i]); 
					}
					else if(nvlProposition[i]>9) {
						
						nvlProposition[i]=9;
						System.out.print(nvlProposition[i]);
						}
					else if(nvlProposition[i]<0) {
						nvlProposition[i]=0;
						System.out.print(nvlProposition[i]);
						}
				
				}
				essai++;
				return deffenseurModOn;
			}
	
	/** 
	 * propoJ donne nouvelle proposition 
     */

	/** 
	 * Mode deffenseur Ordi tente de donner combinaison joueur selon recherche dichotomique
	 * @see Joueur
	 * @see Comparateur
     * @return indicationJ
     */
	public void deffenseur(){ 
		System.out.print("Rentrer la combinaison que l'ordi doit trouver:");
		Utilitaires.demandCombJ();
		
		for(int i = 0; i <= xChiffrComb-1; i++) {

			tabMin[i] = 0;
			tabMax[i] = 9;
			pivot[i] = (tabMax[i]+tabMin[i])/2+1;
			System.out.print(pivot[i]);
			}
		
		deffenseurModOn= true;
		while(deffenseurModOn && essai<nbrEssai) {
			deffenseurModOn= false;	
			recherchDico();
		}
		if(deffenseurModOn==false && essai<=nbrEssai) {
			System.out.print("\nCombinaison trouvé!");
		}
		else {
		System.out.print("\nNombre d'essais maximum atteint");
	}
		}

	}
	

package escapeGame;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * <b>Menu est la classe représentant les régles du jeux et donnant les différentes options du jeux </b>
 * @see Joueur
 * @see Comparateur
 * @author Pulsar
 * @version 1.0
 */

public class Menu {
	
	private String instructions= "Bonjour, ce jeu consiste à deviner une combinaison de 4 chiffres."+
			"\nVous avez 3 modes:"+"\n1-Mode Challenger: Vous tentez de deviner la combinaison de l'ordinateur."+
			"\n2-Mode Défenseur: A vous de mettre à l'épreuve l'ordinateur en définissant le code à deviner."+
			"\n3-Mode Duel: A tour de rôle vous tentez de deviner la combinaison de l'autre."+
			"\n4-Quitter le jeu."+"\n"+
			"\nIndication:Pour chaque chiffre proposé, il vous sera indiqué ou vous aurez à indiquer si celui-ci est:"+
			"\nPlus grand (+)"+
			"\nPlus petit (-)"+
			"\nEgale (=)";
			
	private int modeJeu;
	private String nom;
	private boolean sortirJeu = false;
	Scanner clavier = new Scanner(System.in);
	
	//GetterS/SETTERS POUR CHACUNS DE MES ATTRIBUTS 
	
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public int getModeJeu() {
		return modeJeu;
	}
	
	/** 
	 * Modifie modeJeu
     * @throws IllegalArgumentException si le mode est différent du choix proposé
     */
	public void setModeJeu (int modeJeu) {
		if (modeJeu != 1 || modeJeu != 2 || modeJeu != 3 || modeJeu != 4) {
			throw new IllegalArgumentException("Choisissez le mode: 1, 2 ou 3");
			}
		else {
		this.modeJeu = modeJeu;
		}
	}
	
	/** 
	 * Affiche les instruction
     */
		public void AfficherInstructions(String instructions){
			System.out.println(instructions);
	}
	
	
		/** 
		 * Réccupère et affiche le pseudo
         */
		public void AfficherPseudo() {
			System.out.println("Quel est votre pseudo");
			this.nom = clavier.nextLine();
			//clavier.close();
			System.out.println("Bonjour" +" "+ nom);
	}
		
	
		/** 
		 * Affiche le mode de jeu
         * @throws IllegalArgumentException  Si jamais le choix ne correspond pas aux propositions. 
         * @see Comparateur
         */
		public void AfficherMode()throws IllegalArgumentException{
			
			System.out.println("Quel est votre choix de jeu?");
		
			while(sortirJeu==false){
			try { 
				this.modeJeu = clavier.nextInt();
			
			} catch (Exception e) {
				 sortirJeu = true;
				
			}
			switch (modeJeu) 
			{
			case 1:
				System.out.println("Vous avez choisi le mode Challenger");
				Comparateur2 propC = new Comparateur2();
				propC.challenger();	
				break;
			
			case 2:
				System.out.println("Vous avez choisi le mode Défenseur");
				Comparateur2 propD = new Comparateur2();
				propD.deffenseur();	
				break;
			
			case 3:
				System.out.println("Vous avez choisi le mode Duel");
				Comparateur2 JoueurEscape3 = new Comparateur2();
				JoueurEscape3.devinCombJ();	
				break;
				
			case 4:
				boolean sortirJeu = true;
				break;
			
			case 0:
				sortirJeu = true;
				break;
				
			 default:
				System.out.println("Choisissez le mode: 1, 2 ou 3");
				sortirJeu = true;
				break;
			}
			
	}
			
		}
		
	}
	

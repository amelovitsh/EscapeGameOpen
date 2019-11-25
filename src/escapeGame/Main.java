package escapeGame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class Main {

	public static void main(String[] args) throws IOException {
		LecturConfig appProps = new LecturConfig();
		int xChiffrComb = appProps.getPropertyXchiffrComb();
		int nbrEssai = appProps.getPropertyNbrEssai();
		boolean moDev = appProps.getPropertyMoDev();
		
		Menu MenuEscape = new Menu();	
		
		MenuEscape.afficherPseudo();
		MenuEscape.afficherMode();
		
		//Joueur JoueurEscape = new Joueur(); 
		//JoueurEscape.demandCombJ();	
		
		
		}

}



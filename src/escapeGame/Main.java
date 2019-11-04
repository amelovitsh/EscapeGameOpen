package escapeGame;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
public class Main {

	public static void main(String[] args) {
		LecturConfig appProps = new LecturConfig();
		appProps.load(new FileInputStream(config.properties));
		int appXChiffrComb = appProps.getProperty("xChiffrComb");
		int appNbrEssai = appProps.getProperty("nbrEssai");
		boolean appMoDev = appProps.getProperty("moDev");
		
		Menu MenuEscape = new Menu();	
		MenuEscape.AfficherInstructions(MenuEscape.getInstructions());
		
		MenuEscape.AfficherPseudo();
		MenuEscape.AfficherMode();
		
		Joueur JoueurEscape = new Joueur(); 
		JoueurEscape.demandCombJ();	
		
		
		}

}



package escapeGame;

public class Main {

	public static void main(String[] args) {
		/*private String rootPath;
		String appConfigPath = rootPath + "config.properties";
		Properties appProps = new Properties();
		appProps.load(new FileInputStream(config.properties));
		String appXChiffrComb = appProps.getProperty("xChiffrComb");
		assertEquals("4", xChiffrComb);
		String appNbrEssai = appProps.getProperty("nbrEssai");
		assertEquals("100", nbrEssai); 
		String appMoDev = appProps.getProperty("moDev");
		assertEquals("false", moDev);
		*/
		
		Menu MenuEscape = new Menu();	
		MenuEscape.AfficherInstructions(MenuEscape.getInstructions());
		
		//Ordi OrdiEscape = new Ordi();
		//OrdiEscape.GenerCombO();
		
		MenuEscape.AfficherPseudo();
		MenuEscape.AfficherMode();
		
		Joueur JoueurEscape = new Joueur(); 
		JoueurEscape.demandCombJ();	
		
		
		}

}



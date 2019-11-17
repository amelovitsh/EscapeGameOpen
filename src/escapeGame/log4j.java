package escapeGame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j {

		private final Logger logger = LogManager.getLogger();
		//logger.debug("msg de debogage");
	    //logger.info("msg d'information");
	    //logger.warn("msg d'avertissement");
	   // logger.error("msg d'erreur");
	   // logger.fatal("msg d'erreur fatale"); 
		
		public void DebugJeu(LecturConfig) {
			logger.trace("\n mode devellopeur"+ LecturConfig.getPropertyMoDev()+
					"\n Nombre d'essai"+ LecturConfig.getPropertyNbrEssai()+
					"\n Nombre de chiffres de la combinaison"+ LecturConfig.getPropertyXchiffrComb();
		}

}

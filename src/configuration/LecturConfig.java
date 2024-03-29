package configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class LecturConfig {
	FileInputStream fis;
	int xChiffrComb;
	int nbrEssai;
	boolean moDev;
	private Properties p = new Properties();
	public LecturConfig() {
		 try {
			fis =new FileInputStream( new File("config.properties"));

			p.load(fis);
			xChiffrComb =Integer.parseInt(p.getProperty("xChiffrComb"));
			nbrEssai=Integer.parseInt(p.getProperty("nbrEssai"));
			moDev=Boolean.parseBoolean(p.getProperty("moDev"));
		 } catch (IOException e) {
			 System.out.print("erreur");
			 xChiffrComb= 4;
			 nbrEssai= 20;
			 moDev=true;
		}
	}
	
	 public int getPropertyXchiffrComb(){
		return xChiffrComb;
	}
	
	public int getPropertyNbrEssai(){
		return nbrEssai;
	}
	
	public boolean getPropertyMoDev(){
		return moDev;
	}

}

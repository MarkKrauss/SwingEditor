package source.MVC.model;

import source.EditorInterface.IniModelInterface ;

import java.io.*;
import java.util.*;

/**
 * Anlegen des IniModel. Hohlt sich die Werte aus der editor.ini
 * 
 * @author Markus Krauss
 * @version 0.2
*/
public class IniModel implements IniModelInterface {
   // Attribute der Klasse IniModel
   private File datei;
   private Properties iniFile;
   
   public IniModel() {
      try {
         // Ini-Datei einlesen
         datei = new File(INIFILE);
         
         this.readIniFile(datei);
         
      } catch (Exception e) {
         iniFile = new StandardIniProperty();
         storeIniModel();
         System.out.print("ERROR INI-FILE NOT FOUND! CREATED STANDARD-INI");
      }      
      
   }
   
   /**
   * Methode: liest die Ini-Datei
   *
   * @param f Dateiname
   */
   public Properties readIniFile(File f) throws Exception { 
      FileReader in = new FileReader(f);
      iniFile = new Properties();      
      iniFile.load(in);
      in.close();
      
      return iniFile;        
   }
   
   /**
   * Methode: speichert die Ini-Datei
   */
   private void storeIniModel() {
      try {
         File f = new File(INIFILE);
         // auch als FileOutputStream möglich
         // FileOutputStream out = new FileOutputStream(f);
         FileWriter out = new FileWriter(f);
         // iniFile siehe Klasse IniModel
         iniFile.store(out, "STANDARD INI File");
         out.close();
      }
      catch(IOException ioe) {
         // Sonst irgendwas ist schief gegangen
         System.out.println("Schreibfehler"); 
      }
      
   }
   
   /**
   * Methode: liest einen Wert aus der INI-Property
   * @param key Schluesselwert
   */
   public  String getIniValue(String key) {
      //return "Ergebnis zurückgeben";
      if(iniFile == null){
         System.out.println("nicht da");
      }
      
      return iniFile.getProperty(key) ;        
      
   }
   
   /**
   * Methode: liest einen Wert aus der INI-Property
   * @param key Schluesselwert
   */
   public int getIniValueToInt(String key) {
      //return 0 ;
      return (new Integer(getIniValue(key))).intValue();
   }
   
   /**
   * Innerer Klasse: für die StandardIni-Property
   */
   public class StandardIniProperty extends Properties {
      // Werte für die StandardIni-Property
      public StandardIniProperty() {
         setProperty(TITLE, "Standard-Editor");
         setProperty(X_SIZE, "500");
         setProperty(Y_SIZE, "350");
         setProperty(X_POS, "100");
         setProperty(Y_POS, "100");
         setProperty(PIC_WIDTH, "400");
         setProperty(PIC_HEIGHT, "300");
         setProperty(LANG, "de");
         setProperty(COUNTRY, "DE");
         setProperty(FILTER, "*.jpg,*.pgn,*.gif");
         setProperty(BACKUP, "0");
      }
   }
}

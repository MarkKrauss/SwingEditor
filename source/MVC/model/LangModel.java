package source.MVC.model;
import source.MVC.model.IniModel;
import source.EditorInterface.LangModelInterface ;
//import source.lib.EditorException;
//import source.lib.XMLResourceBundleControl;

import java.util.*;

/**
 * Anlegen des LanguageModel. Hohlt sich die Werte aus der language.propertie
 * 
 * @author Markus Krauss
 * @version 0.2
*/ 
public class LangModel implements LangModelInterface {
   public static final IniModel KONFIG ;
   public final static String lang;
   public final static String loc;
   static {
      // IniFile einlesen
      KONFIG = new IniModel();        
      // Parameter fuer die Sprache aus der Ini-Datei lesen und die Locale erzeugen      
      lang = KONFIG.getIniValue(IniModel.LANG);
      loc = KONFIG.getIniValue(IniModel.COUNTRY);
      
   }
   public final static String LANGUAGE_FILE = "source.resource.lang_"+lang+"_"+loc;
   
   private static ResourceBundle langFile;
   
   /**
   * Konstruktor
   * @param loc
   */
   public LangModel(Locale loc) {
      this.readResourceBundle(LANGUAGE_FILE , loc);
   }
   
   /**
   * Methode liest RessourceBundle
   * @param pfad Dateipfad
   * @param lokale Dateiname
   */
   public static ResourceBundle readResourceBundle(String pfad, Locale lokale) {
      ResourceBundle lang = null;
      try {
         langFile = ResourceBundle.getBundle(pfad, lokale);
      }
      catch (MissingResourceException mre) {
         System.out.println("Sprachdatei fehlt!");
      }
      return langFile;
   }
   
   
   /**
   * Methoden zum Lesen der Werte zu einem Key
   * @param key Schluesselwert
   */
   public String getLangValue(String key) {
      return langFile.getString(key) ;
   }
   /**
   * Methoden zum Lesen der Werte zu einem Key
   * @param key Schluesselwert
   */
   public int getLangValueToInt(String key) {
      return Integer.parseInt(langFile.getString(key)); 
   }   
   
}

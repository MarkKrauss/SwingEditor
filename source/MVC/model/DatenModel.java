package source.MVC.model;

import source.EditorInterface.DatenModelInterface;
import source.MVC.view.EditorException;
import source.MVC.view.EditorFileChooser;

import java.io.*;
import java.awt.image.* ;
import java.util.*;
import javax.imageio.*;
/**
 * Uebernimmt den Datenaustausch des Editors mit dem Datentraeger
 *
 * @author Markus Krauss
 * @version 0.3
 */
public class DatenModel implements DatenModelInterface {
   private boolean bildGeladen = false;
   private BufferedImage originalBild;
   private File datei;
   private String openme, saveme, FilterText, Filter;
   
   public static final IniModel KONFIG ;
   public static final LangModel LANG ;
   
   static {
      KONFIG = new IniModel();        
      Locale loc = new Locale(KONFIG.getIniValue(IniModel.LANG), KONFIG.getIniValue(IniModel.COUNTRY));
      LANG = new LangModel(loc) ;
   }
   
   /**
   * Konstruktor
   * 
   */
   public DatenModel() {   }
   
   /**
   * Methode, Bild laden mit Editorfilechooser
   * 
   */
   public void laden() throws EditorException {
      FilterText = getText(LANG.getLangValue(LangModel.TEXT_FILTER_DESCRIPTION));
      Filter = getText(KONFIG.getIniValue(IniModel.FILTER));
      
      EditorFileChooser fc = new EditorFileChooser(null, 
      Filter, FilterText);
      int butn = fc.showOpenDialog(null);
      
      if(butn == EditorFileChooser.APPROVE_OPTION)
      {
         // Ausgabe der ausgewaehlten Datei         
         openme = fc.getSelectedFile().getName();
      }
      
      datei = new File(openme);
      
      try {
         originalBild = ImageIO.read(datei);
      } catch (IllegalArgumentException iae) {
         throw new EditorException("Programmfehler!") ;
      } catch (IOException ioe) {
         throw new EditorException("Lesefehler (Datei)!") ;
      }
      bildGeladen = true ;             
   }
   
   /**
   * Methode, Bild speichern
   * @param bild welches übergeben wird
   */
   public void speichern(BufferedImage bild) throws EditorException {
      FilterText = getText(LANG.getLangValue(LangModel.TEXT_FILTER_DESCRIPTION));
      Filter = getText(KONFIG.getIniValue(IniModel.FILTER));
      
      EditorFileChooser fc = new EditorFileChooser(null, 
      Filter, FilterText);
      int butn = fc.showSaveDialog(null);
      
      if(butn == EditorFileChooser.APPROVE_OPTION)
      {
         // Eingabe der ausgewaehlten Datei         
         saveme = fc.getSelectedFile().getName();
      }
      
      datei = new File(saveme);
      
      if(!datei.exists())
      {
         try
         {
            // Erstelle Datei auf Festplatte            
            ImageIO.write(bild, "JPG", datei);
            boolean wurdeErstellt = datei.createNewFile();
            // Überprüfung, ob die Datei erstellt wurde
            if(wurdeErstellt)
            {
               System.out.print("Bild wurde erfolgreich" +
               " auf dem Laufwerk c erstellt");
            }
            else
            {
               System.out.print("Bild wurde nicht erfolgreich" +
               " auf dem Laufwerk c erstellt");
            }
         }
         catch (IOException ex)
         {
            // Ein Fehler ist aufgetreten.
            ex.printStackTrace();
         }
         
      }
   }
   
   public BufferedImage holeBild() {
      return originalBild;
   }
   
   public String gibFileName() {
      // hier ergänzen                
      return datei.getName();
   }
   
   /**
   * Methode: getText
   * @param zKette String
   */
   private String getText(String zKette) {
      int pos = zKette.indexOf('*');
      String z = zKette;
      
      if (pos != -1) {
         z = zKette.substring(0, pos) + zKette.substring(pos + 1);
      }
      
      return z ;
   }
}

package source.MVC.view;

// Achtung: Die Klasse FileFilter ist in 2 Paketen enthalten:
// java.io und javax.swing.filechooser
// Deshalb müssen sie die Klasse File und FileFilter beim Import
// explizit angeben, da sonst die Klasse FileFilter nicht gefunden
// oder die falsche Klasse importiert wird.

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

/**
 * Managed das Laden und Speichern einer Bild-Datei
 *
 *
 * @version 0.2
 * @author Markus Krauss
 */
public class EditorFileChooser extends JFileChooser {
   // globale Konstanten für den Filedialog
   public final static int OPEN_DIALOG = 1;
   public final static int SAVE_DIALOG = 2;
   
   public final static char EXTENTION_SEPARATOR = '.' ;
   public final static char FILTER_SEPARATOR = ',' ;
   public final static String CURRENT_DIRECTORY = "." ;
   public final static String WORKDIR = System.getProperty("user.dir");
   
   // Attribute des EditorFileChooser
   private JFrame fenster;
   private FileFilter dateiFilter;
   private String filterBeschreibung;
   private String filter;
   
   /**
   * Konstruktor EditorfileCHooser
   *
   * @param fenster
   * @param filter
   * @param filterBeschreibung
   */
   public EditorFileChooser(JFrame fenster, String filter, String filterBeschreibung) {
      // Filter und Filterbeschreibung werden aus der
      // IniDatei gelesen und im Konstruktor übergeben
      this.fenster = fenster;
      this.filter = filter ;
      this.filterBeschreibung = filterBeschreibung ;
      
      // FileSelection-Mode und Textfilter ergänzen
      setCurrentDirectory(new File(CURRENT_DIRECTORY));
      setFileSelectionMode(JFileChooser.FILES_ONLY);
      
      dateiFilter = new TextFilter();
      addChoosableFileFilter(dateiFilter);
      setFileFilter(dateiFilter);
   }
   
   /**
   * Methode hohlt den Dateinamen
   *
   * @param mod Hohlt den Dateinamen
   * @return datei gibt die Datei
   */
   public File getFileName(int mod) {
      File datei = null;
      int auswahl = 0;
      
      if (mod == OPEN_DIALOG) {
         auswahl = showOpenDialog(fenster);
      }
      
      if (mod == SAVE_DIALOG) {
         auswahl = showSaveDialog(fenster);
      }
      
      if (auswahl == JFileChooser.APPROVE_OPTION) {
         datei = getSelectedFile();
      }
      
      return datei;
   }
   
   /**
   * Innere Klasse mit für den FileChooser-Filter
   *
   */
   public class TextFilter extends FileFilter {
      private String[] filterExtensions;
      
      public TextFilter() {
         // Auf die Attribute filter und filterBeschreibug der
         // aüßeren Klasse kann man einfach zugreifen
         
         
         
         // Hier den Filter mit Hilfe der Methode split in seine
         // Bestandteile zerlegen und im Array filterExtensions
         // speichern.
      }
      
      /**
      * Methode: Akzeptiere alle Verzeichnisse und alle Files entsprechend
      *  der Filter-Extensions.
      *
      * @param f Dateiname des Bildes
      * @return false 
      * @return true
      */
      public boolean accept(File f) {
         if (f.isDirectory()) {
            return true;
         }
         String extension = getExtension(f);
         if (extension != null) {
            if (extension.equals("jpg") ||
            extension.equals("gif") ||
            extension.equals("jpeg") ||
            extension.equals("png") ) {
               return true;
            }
         }
         return false;
      }
      
      /**
      * Die Beschreibung dieses Filters der Filter-Extensions.
      * 
      * @return filterBeschreibung
      */
      public String getDescription() {
         return filterBeschreibung + " (" + filter + ")";
      }
      
      /**
      * Hilfsmethoden
      *
      * @param f Dateiname des Bildes
      * @return ext 
      */
      private String getExtension(File f) {
         String ext = null;
         String s = f.getName();
         int i = s.lastIndexOf(EXTENTION_SEPARATOR);
         
         if ((i > 0) && (i < (s.length() - 1))) {
            ext = s.substring(i + 1).toLowerCase().trim();
         }
         
         return ext;
      }
   }
}

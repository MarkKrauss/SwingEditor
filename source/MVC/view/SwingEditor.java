package source.MVC.view;

import source.EditorInterface.BildAreaInterface;
import source.EditorInterface.FrameInterface;
import source.EditorInterface.MenueLeisteInterface;
import source.MVC.controller.FensterListener;
import source.MVC.model.IniModel;
import source.MVC.model.LangModel;

// Systemimporte
import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.util.*;

/**
 * Anlegen der Fenstereigenschaften. Hinzufügen von BildArea, Nachrichtenzeile
 * und Menueleiste zum SwingEditor-Fenster. 
 * Innere Klasse FrameAdapter für den
 * Zugriff auf lokale Variablen der Klasse SwingEditor von außerhalb.
 * 
 * @author Markus Krauss
 * @version 0.5
*/ 
public class SwingEditor extends JFrame {
   // Attribute des Fensters
   public JFrame fenster ;
   private MenueLeiste menueLeiste;
   private BildArea bArea;
   private NachrichtenZeile nZeile ;
   //private FensterListener listener;
   /*
   public static final IniModel KONFIG ;
   public static final LangModel LANG ;
   
   static {
      // IniFile einlesen
      KONFIG = new IniModel();        
      // Parameter fuer die Sprache aus der Ini-Datei lesen und die Locale erzeugen      
      Locale loc = new Locale(KONFIG.getIniValue(IniModel.LANG), KONFIG.getIniValue(IniModel.COUNTRY));
      // Sprachdatei einlesen
      LANG = new LangModel(loc) ;
   } */
   /**
   * Konstruktor: Setzt die Eigenschaften des SwingEditor-Fensters.
   */
   public SwingEditor() {
      super("Editor");
      fenster=this;
      setSize(500,500);                 
      
      setLayout(new BorderLayout());
      Container cp = getContentPane();
      
      //Felder Implementieren
      bArea = new BildArea(new FrameAdapter());
      nZeile = new NachrichtenZeile();
      JScrollPane scrollpane = new JScrollPane(bArea); 
      menueLeiste = new MenueLeiste(new FrameAdapter());
      
      //Felder einfügen
      cp.add(menueLeiste, BorderLayout.NORTH);
      cp.add(scrollpane, BorderLayout.CENTER);
      cp.add(nZeile, BorderLayout.SOUTH);
      
      this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
      addWindowListener(new FensterListener(new FrameAdapter()));     
      
      
      setVisible(true);
   }  // Ende Konstruktor SwingEditor
   
   /**
   * Innere Klasse: Frame Adapter
   */
   public class FrameAdapter implements FrameInterface {
      
      /**
      * Zugriffsmethoden für das Textfeld
      */
      public JFrame getFrame() {   
         return fenster;
      }
      public MenueLeisteInterface getMenueLeiste() { 
         return menueLeiste;
      }
      public BildAreaInterface getBildArea() {
         return bArea;
      }
      public void setMessage(String nachricht){
         nZeile.setMessage(nachricht);
      }      
   }
} // Ende Klasse SwingEditor

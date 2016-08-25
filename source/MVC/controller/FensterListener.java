package source.MVC.controller;

import source.EditorInterface.FrameInterface;
import source.lib.FktLib;
import source.MVC.model.IniModel;
import source.MVC.model.LangModel;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.*;

/**
 * Listener fuer die Fensterklasse SwingEditor. 
 * Ordentliches Schliessen des SwingEditors.
 * 
 * @version 0.3
 * @author Markus Krauss
 */
public class FensterListener extends WindowAdapter implements ActionListener{
   private FrameInterface fenster ;
   
   private String cancelButtonText, yesButtonText, noButtonText, titel, nachricht;
   public static final IniModel KONFIG ;
   public static final LangModel LANG ;
   static {
      KONFIG = new IniModel();        
      Locale loc = new Locale(KONFIG.getIniValue(IniModel.LANG), KONFIG.getIniValue(IniModel.COUNTRY));
      LANG = new LangModel(loc) ;
   }
   /**
   * Konstruktor: Uebergabe des FrameInterface an lokale Variabel fenster.
   * @param fensterInterface FensterInterface parameter
   */
   public FensterListener(FrameInterface fensterInterface) {
      this.fenster = fensterInterface ;
   }
   
   /**
   * Methode: beendenDialog
   *
   * @param e AvtionEvent
   */
   public void actionPerformed(ActionEvent e){
      beendenDialog();
   }                          
   /**
   * Methode: beendenDialog
   *
   * @param e AvtionEvent
   */
   public void windowClosing(WindowEvent e){
      beendenDialog();
   }
   
   public void beendenDialog(){ 
      
      String yesButtonText = getText(LANG.getLangValue(LangModel.YES_BUTTONTEXT));
      String noButtonText = getText(LANG.getLangValue(LangModel.NO_BUTTONTEXT));
      String cancelButtonText = getText(LANG.getLangValue(LangModel.CANCEL_BUTTONTEXT));
      
      titel = getText(LANG.getLangValue(LangModel.BEENDEN));
      nachricht = getText(LANG.getLangValue(LangModel.SICHER));
      
      boolean anfrage = FktLib.anfrage(fenster.getFrame(), titel, nachricht,yesButtonText,noButtonText,cancelButtonText);
      
      if (anfrage==true) {
         fenster.getFrame().setVisible(false);
         fenster.getFrame().dispose();
         System.exit(0);
      }
   }
   
   public void windowActivated(WindowEvent e) {};
   public void windowDeactivated(WindowEvent e) {};
   public void windowDeiconified(WindowEvent e) {};
   public void windowIconified(WindowEvent e) {};
   public void windowOpened(WindowEvent e) {};
   public void windowClosed(WindowEvent e) {};
   
   private String getText(String zKette) {
      int pos = zKette.indexOf('*');
      String z = zKette;
      
      if (pos != -1) {
         z = zKette.substring(0, pos) + zKette.substring(pos + 1);
      }
      
      return z ;
   }
}

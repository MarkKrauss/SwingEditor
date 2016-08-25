package source.MVC.controller;

import source.EditorInterface.FrameInterface;
import source.MVC.controller.MenueListener;
import source.MVC.view.MenueLeiste;

import java.awt.event.*;

/**
 * Listener der MenueLeiste. 
 * Setzten der Aktionen beim Klick auf Menü-Einträge.
 *
 * @author Markus Krauss
 * @version 0.2
 */
public class MenueListener implements ActionListener {
   // Attribute der Klasse MenueListener
   private FrameInterface fenster;
   
   /**
   * Konstruktor: Uebergabe des FrameInterface an die Variable fenster
   *
   * @param f FensterInterface des Editors
   */
   public MenueListener (FrameInterface f) {
      this.fenster= f;   
      
   } // Ende Konstruktor MenueListener
   
   /**
   * Bei uebereinstimmung der Variablen, fuehre Befehle aus
   *
   * @param e AvtionEvent
   */
   public void actionPerformed(ActionEvent e) {
      String cmd = e.getActionCommand() ;
      
      // Aktion Menue Datei laden
      if (cmd.equals(MenueLeiste.LOAD)) {
         //frameAdapter = fenster
         fenster.getBildArea().ladenDialog();
         fenster.getMenueLeiste().menueSpeichernUnter(true);
         fenster.getMenueLeiste().menueBearbeitenBool(true);
      }
      if (cmd.equals(MenueLeiste.SAVE_AS)) {
         fenster.getBildArea().speichernDialog();         
      }
      if (cmd.equals(MenueLeiste.EXIT)) {
         fenster.getBildArea().beendenDialog();
      }
      if (cmd.equals(MenueLeiste.ORIGINAL)) {
         fenster.getBildArea().originalDialog();
      }
      if (cmd.equals(MenueLeiste.DARK)) {
         fenster.getBildArea().dunklerDialog();
      }
      if (cmd.equals(MenueLeiste.BRIGHT)) {
         fenster.getBildArea().hellerDialog();
      }
      if (cmd.equals(MenueLeiste.NEGATIV)) {
         fenster.getBildArea().negativDialog();
      }
      if (cmd.equals(MenueLeiste.GREY)) {
         fenster.getBildArea().grauStufeDialog();
      }
      if (cmd.equals(MenueLeiste.THRESHOLD)) {
         fenster.getBildArea().schwellenWertDialog();
      }
      if (cmd.equals(MenueLeiste.FILTER6)) {
         fenster.getBildArea().filter6Dialog();
      }
      if (cmd.equals(MenueLeiste.FILTER7)) {
         fenster.getBildArea().filter7Dialog();
      }
      if (cmd.equals(MenueLeiste.HELP)) {
         fenster.getBildArea().hilfeDialog();
      }
      if (cmd.equals(MenueLeiste.INFO)) {
         fenster.getBildArea().infoDialog();
      }
      // Aktionen hier ergänzen
      
      
      
   } // Ende Methode actionPerformed
}


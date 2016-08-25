package source.MVC.view;

import source.EditorInterface.MenueLeisteInterface;
import source.EditorInterface.FrameInterface;
import source.MVC.controller.FensterListener;
import source.MVC.controller.MenueListener;
import source.MVC.model.IniModel;
import source.MVC.model.LangModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Aufbau der Menueleiste und Hotkeys. 
 * Funktion zur Aktivierung von nicht
 * aktivierten MenueEinträgen.
 * 
 * @author Markus Krauss
 * @version 0.4
 */
public class MenueLeiste extends JMenuBar implements MenueLeisteInterface {
   
   // Welche Taste wird für die Menüsteuerung per Tastatur benutzt?
   // In Windowsysteme erhält man die CTRL-Taste, in MAC OS X Systeme erhält
   // man die COMMAND-Taste.
   public static final int CTRL_COMMAND_MASK = Toolkit.getDefaultToolkit()
   .getMenuShortcutKeyMask() ;
   
   // Menüs
   private JMenu menueDatei,menueBearbeiten,hilfe;   
   // Menüeintrage
   private JMenuItem dateiLaden,dateiSpeichernUnter,dateiEnde,
   original,dunkler,heller,negativ,grauStufe,
   schwellenWert,filter6,filter7,info;
   // Menülistener
   private MenueListener mListener;
   
   public static final IniModel KONFIG ;
   public static final LangModel LANG ;
   
   static {
      KONFIG = new IniModel();        
      Locale loc = new Locale(KONFIG.getIniValue(IniModel.LANG), KONFIG.getIniValue(IniModel.COUNTRY));
      LANG = new LangModel(loc) ;
   }
   
   /**
   * Konstruktor: Aufbau der MenueLeiste
   *
   * @param f FensterInterface des Editors
   */
   public MenueLeiste(FrameInterface f) {
      mListener = new MenueListener(f);
      
      // 1. Menü
      menueDatei = new JMenu(getText(LANG.getLangValue(LangModel.FILE)));
      menueDatei.setMnemonic(KeyEvent.VK_D);
      
      //Unterpunkte
      dateiLaden = new JMenuItem(getText(LANG.getLangValue(LangModel.FILE_LOAD)));
      dateiLaden.setMnemonic(KeyEvent.VK_N);
      KeyStroke kl = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK);
      dateiLaden.setAccelerator(kl);
      dateiLaden.setActionCommand(LOAD);
      dateiLaden.addActionListener(mListener);
      menueDatei.add(dateiLaden);
      
      dateiSpeichernUnter = new JMenuItem(getText(LANG.getLangValue(LangModel.FILE_SAVE_AS)));
      dateiSpeichernUnter.setMnemonic(KeyEvent.VK_S);
      KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK);
      dateiSpeichernUnter.setAccelerator(ks);
      dateiSpeichernUnter.setActionCommand(SAVE_AS);
      dateiSpeichernUnter.addActionListener(mListener);
      dateiSpeichernUnter.setEnabled(false);
      menueDatei.add(dateiSpeichernUnter);
      
      menueDatei.addSeparator();
      
      dateiEnde = new JMenuItem(getText(LANG.getLangValue(LangModel.FILE_EXIT)));
      dateiEnde.setMnemonic(KeyEvent.VK_Q);
      KeyStroke ke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK);
      dateiEnde.setAccelerator(ke);
      dateiEnde.setActionCommand(EXIT);
      dateiEnde.addActionListener(mListener);
      menueDatei.add(dateiEnde);
      
      
      // 2. Menü
      menueBearbeiten = new JMenu(getText(LANG.getLangValue(LangModel.EDIT)));
      menueBearbeiten.setMnemonic(KeyEvent.VK_B);
      menueBearbeiten.setEnabled(false);
      
      //Unterpunkte
      original = new JMenuItem(getText(LANG.getLangValue(LangModel.EDIT_ORIGINAL)));
      original.setMnemonic(KeyEvent.VK_O);
      KeyStroke ko = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK);
      original.setAccelerator(ko);
      original.setActionCommand(ORIGINAL);
      original.addActionListener(mListener);
      menueBearbeiten.add(original);
      
      dunkler = new JMenuItem(getText(LANG.getLangValue(LangModel.EDIT_DARK)));
      dunkler.setActionCommand(DARK);
      dunkler.addActionListener(mListener);
      menueBearbeiten.add(dunkler);
      
      heller = new JMenuItem(getText(LANG.getLangValue(LangModel.EDIT_BRIGHT)));
      heller.setActionCommand(BRIGHT);
      heller.addActionListener(mListener);
      menueBearbeiten.add(heller);
      
      negativ = new JMenuItem(getText(LANG.getLangValue(LangModel.EDIT_NEGATIV)));
      negativ.setActionCommand(NEGATIV);
      negativ.addActionListener(mListener);
      menueBearbeiten.add(negativ);
      
      grauStufe = new JMenuItem(getText(LANG.getLangValue(LangModel.EDIT_GREY)));
      grauStufe.setActionCommand(GREY);
      grauStufe.addActionListener(mListener);
      menueBearbeiten.add(grauStufe);
      
      schwellenWert = new JMenuItem(getText(LANG.getLangValue(LangModel.EDIT_THRESHOLD)));
      schwellenWert.setActionCommand(THRESHOLD);
      schwellenWert.addActionListener(mListener);
      menueBearbeiten.add(schwellenWert);
      
      filter6 = new JMenuItem(getText(LANG.getLangValue(LangModel.EDIT_REFLECT)));
      filter6.setActionCommand(FILTER6);
      filter6.addActionListener(mListener);
      menueBearbeiten.add(filter6);
      
      filter7 = new JMenuItem(getText(LANG.getLangValue(LangModel.EDIT_FILTER7)));
      filter7.setActionCommand(FILTER7);
      filter7.addActionListener(mListener);
      menueBearbeiten.add(filter7);
      
      
      // 3. Menü
      hilfe = new JMenu(getText(LANG.getLangValue(LangModel.HELP)));
      hilfe.setMnemonic(KeyEvent.VK_H);        
      hilfe.setActionCommand(HELP);
      hilfe.addActionListener(mListener);
      
      //Unterpunkte
      info = new JMenuItem(getText(LANG.getLangValue(LangModel.HELP_INFO)));
      info.setMnemonic(KeyEvent.VK_I);
      KeyStroke ki = KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK);
      info.setAccelerator(ki);
      info.setActionCommand(INFO);
      info.addActionListener(mListener);
      hilfe.add(info);
      
      
      //Menü HauptPunkte in MenueLeiste hinzufügen
      add(menueDatei);
      add(menueBearbeiten);
      add(hilfe);
   } // Ende Konstruktor Menueleiste
   
   
   /**
   * aktiviere Speichern Menue
   *
   * @param b bekommt ein boolean wenn Bild bearbeitet wurde
   */
   public void menueSpeichernUnter(boolean b){
      dateiSpeichernUnter.setEnabled(b);;
   }
   /**
   * aktiviere Bearbeiten Menue
   *
   * @param b bekommt ein boolean wenn Bild bearbeitet wurde
   */
   public void menueBearbeitenBool(boolean b){
      menueBearbeiten.setEnabled(b);;
   }
   /**
   * liest aus einem String das erste Zeichen hinter *. Dies ist das
   * mnemonische Zeichen für die Bedienung mit der Tastatur.
   *
   * @param zKette
   * @return mnemonic
   */
   private char getMnemonic(String zKette) {
      // Mnemonics nicht setzen, falls 0 zurück gegeben wird!
      char mnemonic = 0 ;
      int pos = zKette.indexOf('*');
      String s = zKette.toUpperCase();
      
      if (pos != -1) {
         mnemonic = s.charAt(pos + 1);
      }
      
      return mnemonic ;
   }
   
   /**
   * Schneidet aus einem String das Zeichen * und fügt die Teilstrings
   * davor und dahinter wieder zu einem String zusammen und gibt
   * diesen zurück.
   *
   * @param zKette
   * @return z
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

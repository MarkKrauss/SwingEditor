package source.lib ;
import source.EditorInterface.FrameInterface;   
//import source.EditorInterface.MenueLeisteInterface;
import source.MVC.model.DatenModel;
import source.MVC.view.EditorFileChooser;
import source.MVC.model.IniModel;
import source.MVC.model.LangModel;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


/**
 * Custom Dialoge für eigene Buttontexte
 *
 * @author Markus Krauss
 * @version 0.2
 */
public class JaNeinDialog extends JDialog {
   public FrameInterface fenster;
   public static final IniModel KONFIG ;
   public static final LangModel LANG ;
   
   static {
      KONFIG = new IniModel();        
      Locale loc = new Locale(KONFIG.getIniValue(IniModel.LANG), KONFIG.getIniValue(IniModel.COUNTRY));
      LANG = new LangModel(loc) ;
   }
   public String ja = LANG.getLangValue(LangModel.YES_BUTTONTEXT);
   public String nein = LANG.getLangValue(LangModel.NO_BUTTONTEXT);
   public String abbruch = LANG.getLangValue(LangModel.CANCEL_BUTTONTEXT);
   public String message4 = LANG.getLangValue(LangModel.MESSAGE4);
   public String message9 = LANG.getLangValue(LangModel.MESSAGE9);
   
   private JLabel textfield = new JLabel(message4);
   private JButton yes = new JButton(ja);
   private JButton no = new JButton(nein);
   private JButton cancel = new JButton(abbruch);
   
   /**
   * Konstruktor 
   *
   * @param f FrameInterface des Editors
   */
   public JaNeinDialog(FrameInterface f) {
      fenster = f;
      setTitle(message9);
      setSize(300,120);
      Container cp = getContentPane() ;
      cp.setLayout(new BorderLayout());
      Panel oben = new Panel();
      Panel unten = new Panel();
      oben.setLayout(new FlowLayout());
      unten.setLayout(new FlowLayout());
      
      cp.add("North", oben);
      cp.add("Center", unten);
      
      oben.add(textfield);
      unten.add(yes);
      unten.add(no);
      unten.add(cancel);
      
      yes.setActionCommand("yes");
      no.setActionCommand("no");
      cancel.setActionCommand("cancel");
      
      //pack();
      setLocationRelativeTo(fenster.getFrame());
      setVisible(true);
   }
   
   /**
   * Methode
   *
   * @param listener Listener fuer die Custombuttons
   *
   */
   public void addConfirmListener(ActionListener listener) {
      yes.addActionListener(listener);
      no.addActionListener(listener);
      cancel.addActionListener(listener);
   }
   
}
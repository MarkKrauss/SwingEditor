package source.MVC.view;

import source.EditorInterface.NachrichtenZeileInterface;

// Systemimporte
import java.awt.*;
import javax.swing.*;



/**
 * NachrichtenZeile bestehend aus dem Label Meldung 
 * und dem Texfeld nZeile.
 * Dient zur Anzeige von Meldungen.
 *
 * @author Markus Krauss
 * @version 0.2
 */
public class NachrichtenZeile extends JPanel implements NachrichtenZeileInterface {
   //private JTextField nZeile;
   private JLabel nZeile; //ich Benutze das Label aus rein Optischen gründen, ich finde es schöner wenn man die Meldung nicht "manipulieren" kann
   private JLabel labelText;
   
   /**
   * Konstruktor: Aufbau der Nachrichtenzeile
   */
   public NachrichtenZeile() {
      setLayout(new BorderLayout(10,0));
      
      labelText = new JLabel("Meldung: ");
      //nZeile = new JLabel(30);
      nZeile = new JLabel("");
      
      add(labelText, BorderLayout.WEST);
      add(nZeile, BorderLayout.CENTER);
      
   }
   
   
   /**
   * Methoden implementieren (siehe Interface)
   * 
   * @param t
   */
   public void setMessage(String t) { nZeile.setText(t) ; }
   
   /**
   * Methoden implementieren (siehe Interface)
   * 
   * @return ""
   */
   public String getMessage() { return ""; }
}

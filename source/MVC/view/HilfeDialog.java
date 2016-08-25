package source.MVC.view;

import source.EditorInterface.FrameInterface; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * HilfeDialog des Editors, beinhaltet den Programm Namen, den Author und die Versionsnummer
 *
 * @author Markus Krauss
 * @version 0.1
 */ 
class HilfeDialog extends JDialog implements ActionListener{
   private JLabel autorLabel, progLabel, versLabel;
   private JOptionPane optionPane;
   private String OK_BUTTON = "OK"; 
   private JButton ok;
   
   private FrameInterface fenster;
   
   public HilfeDialog(){
      //super(f);
      setTitle("Info");
      setSize(300,200);  
      
      String prog = "Bild-Editor";      
      String autor = "Autor: Markus Krauss";      
      String version = "version: 0.9";      
      
      progLabel = new JLabel(prog);
      autorLabel = new JLabel(autor);
      versLabel = new JLabel(version);
      
      progLabel.setFont(new Font("Serif", Font.BOLD, 28));
      
      ok = new JButton("OK");
      
      Object[] array = {progLabel, autorLabel,versLabel };
      
      Object[] options = { ok };
      
      optionPane = new JOptionPane(array, JOptionPane.INFORMATION_MESSAGE,
      JOptionPane.YES_NO_OPTION, null, options, options[0]);
      
      setContentPane(optionPane);
      //setLocationRelativeTo(fenster.getFrame());
      
      //Standard Handle window closing correctly.
      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
      addWindowListener ( new WA () ) ; 
      
      //Button gets the first focus.
      addComponentListener(new ComponentAdapter() {
         public void componentShown(ComponentEvent ce) {
            //OK_BUTTON.requestFocusInWindow();
         }
      });
      
      ok.addActionListener(this);
      ok.setActionCommand("OK");
      //setLocationRelativeTo(fenster.getFrame());
      setVisible ( true ) ; 
   }   
   
   /**
   * ActionEvent für Buttons
   *
   * @param ae bekommt ein ActionEvent zugewiesen
   */
   @Override
   public void actionPerformed(ActionEvent ae) {
      String action = ae.getActionCommand();
      if (action.equals("OK")) {
         setVisible(false); 
      }
   }
   
   class WA extends WindowAdapter{ 
      /**
      * WindowEvent für Fensterleiste
      *
      * @param ev bekommt ein ActionEvent zugewiesen
      */
      public void windowClosing ( WindowEvent ev ) { 
         setVisible ( false ) ; 
      } 
   } 
   
   //public BUTTON_ACTIONS getButton() {return aktion;}
}

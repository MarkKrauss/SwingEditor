package source.lib ;
import source.EditorInterface.FrameInterface;
import javax.swing.*;
import java.util.*;
/**
 * Die Klasse enthält Methoden, die keiner speziellen
 * Klasse zugeordnet werden können. Alle Methoden sind als
 * Klassenmethoden impementiert. Die Klasse wird als
 * Funktionsbibliothek benutzt.
 *
 * @author Markus Krauss
 * @version 0.2
 */
public class FktLib {
   public final static String CR_LF = (String) System.getProperty("line.separator");
   public final static String TEXTAREA_LF = "\n";
   private FrameInterface fenster;
   
   /**
   * Methode für einen Frage Dialog
   *
   * @param f ist das Fenster, an das das Dialogfenster gebunden ist.
   */
   private FktLib(FrameInterface f){
      this.fenster = f ;   
   }
   
   /**
   * Methode für einen Frage Dialog
   *
   * @param f ist das Fenster, an das das Dialogfenster gebunden ist.
   * @param titel enthält den Fenstertitel des Dialogfensters,
   * @param nachricht die ausgegeben Nachricht.
   */
   public static boolean anfrage(JFrame f, String titel, String nachricht,
   String yesButtonText, String noButtonText, String cancelButtonText){
      
      
      //Custom dialog Buttontext
      Object[] options = { yesButtonText, noButtonText, cancelButtonText };
      
      int w;
      w = JOptionPane.showOptionDialog(
      f,
      nachricht = nachricht,
      titel = titel,
      //JOptionPane.YES_NO_CANCEL_OPTION,
      //Customdialogbuttontext Aktivieren
      JOptionPane.DEFAULT_OPTION,//hier keine Wirkung
      JOptionPane.QUESTION_MESSAGE,
      null,       //kein eigenes Icon
      options,    // Button beschriftung
      options[2]  // aktiver Button
      );
      
      
      if (w == JOptionPane.NO_OPTION) {
         return false ;         
      }
      if (w == JOptionPane.CANCEL_OPTION) {
         return false ;         
      }
      //Anweisung bei Ja
      if (w == JOptionPane.YES_OPTION){
         return true;
      } 
      return true ;
   }
   
   
   
   
}
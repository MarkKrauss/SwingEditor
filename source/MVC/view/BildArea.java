package source.MVC.view;

import source.EditorInterface.BildAreaInterface;
import source.EditorInterface.FrameInterface;  
import source.MVC.model.DatenModel;
import source.MVC.model.Farbbild;              
import source.MVC.view.EditorFileChooser;
import source.MVC.view.HilfeDialog;
import source.MVC.model.IniModel;
import source.MVC.model.LangModel;
import source.lib.FktLib;                                   
import source.lib.JaNeinDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import java.io.File ;
import java.util.*;

/**
 * Aufbau der BildArea/Anzeige
 *
 * @author Markus Krauss
 * @version 0.4
 */
public class BildArea extends JPanel implements BildAreaInterface {
   private boolean bildGeaendert = false;
   private String cancelButtonText, yesButtonText, noButtonText;
   // Die aktuelle Breite und Höhe des Bildes   
   private int breite;
   private int hoehe;
   private int h,w;
   private FrameInterface fenster;
   private HilfeDialog hilfe;
   private Farbbild bild ;
   private DatenModel dataModel ;
   public static final IniModel KONFIG ;
   public static final LangModel LANG ;    
   private JaNeinDialog janein;            
   static {
      KONFIG = new IniModel();        
      Locale loc = new Locale(KONFIG.getIniValue(IniModel.LANG), KONFIG.getIniValue(IniModel.COUNTRY));
      LANG = new LangModel(loc) ;
   }
   public String bnachricht = LANG.getLangValue(LangModel.MESSAGE3);
   public String btitel = LANG.getLangValue(LangModel.MESSAGE9);
   public String ok = LANG.getLangValue(LangModel.YES_BUTTONTEXT);
   public String cancel = LANG.getLangValue(LangModel.CANCEL_BUTTONTEXT);
   
   /**
   * Konstruktor: Aufbau der BildArea
   *
   * @param f FensterInterface des Editors
   */  
   public BildArea(FrameInterface f) {
      setSize(400, 500);      
      setBorder(new EtchedBorder());      
      this.fenster = f ;                  
      dataModel = new DatenModel() ;           
      
   } // Ende Konstruktor
   
   /**
   * Diese Methode wird vom Laufzeitsystem wiederholt aufgerufen, um
   * das Bild zu zeichnen. Das wiederholte Zeichnen muss mit der
   * Methode repaint() angestoßen werden. 
   *
   * @param g Der Grafik-Kontext für das Zeichnen des Bildes.
   */   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Dimension size = getSize();
      
      if (bild != null) {
         g.drawImage(bild, 0, 0, null);         
      } 
      
   }
   
   /**
   * Geerbte Methode wird redefinieren. Die Methode zeigt dem Layout-Manager 
   * wie groß das Bild ist, sie wird benutzt um das Bild in der Fläche
   * passend zu platzieren.
   *
   * @return Gibt die bevorzugte Größe (als Dimension) des Bildes zurück.
   */
   public Dimension getPreferredSize() {
      return new Dimension(breite, hoehe);
   }
   
   /**
   * Methode des LadenDialogs
   *
   */
   public void ladenDialog(){
      if (!bildGeaendert) {
         try {
            // Bild laden (DatenModel) 
            dataModel.laden();             
            // Bild in die BildArea kopieren
            bild = new Farbbild(dataModel.holeBild()) ;
            // Filename im Fenstertitel eintragen                
            fenster.getFrame().setTitle
            ("Editor" + " - " + dataModel.gibFileName());
            //Parameter im BildArea aktualisieren
            bildGeaendert = false;
            //Hoehe,Breite
            h =  bild.getHeight();
            w =  bild.getWidth();
            this.repaint(); // Bild neu zeichnen
         } catch (EditorException e) {
            fenster.setMessage("Fehler beim Bildlesen!");
         }
      }
      if (bildGeaendert) {
         bildaendernDialog();
      }    
      //fenster.setMessage(size() + "");    
   }
   
   /**
   * Methode des speichernDialogs
   * 
   */  
   public void speichernDialog(){
      if (bildGeaendert) {
         try {
            dataModel.speichern(bild);
         } catch (EditorException e) {
            fenster.setMessage("Fehler beim Bildspeichern!") ;
         }
      }
      else{
         bildaendernDialog();
      }        
      
   }
   /**
   * Methode des beendenDialogs
   * 
   */  
   public void beendenDialog(){
      //fenster.setMessage("Menü Exit gedrückt!") ; 
      if (bildGeaendert) {
         schliessenaendernDialog();
      }        
      else{
         int w;
         w = JOptionPane.showOptionDialog(
         fenster.getFrame(),
         bnachricht,
         btitel,
         //btitel,
         JOptionPane.OK_CANCEL_OPTION,
         //Customdialogbuttontext Aktivieren
         //JOptionPane.DEFAULT_OPTION,//hier keine Wirkung
         JOptionPane.INFORMATION_MESSAGE,
         null,       //kein eigenes Icon
         new String[]{ok, cancel},    // Button beschriftung
         null  // aktiver Button
         );
         if (w == JOptionPane.OK_OPTION){
            fenster.getFrame().setVisible(false);
            fenster.getFrame().dispose();
            System.exit(0);
         } 
         if (w == JOptionPane.CANCEL_OPTION){
            //fenster.setMessage("d");
         } 
      } 
   }
   
   
   /**
   * Methode des originalDialogs
   *  
   */
   public void originalDialog(){
      fenster.setMessage("Menü Original gedrückt!") ;
      bild = new Farbbild(dataModel.holeBild()) ;      
      this.repaint();
      bildGeaendert = true;
   }
   /**
   * Methode des dunkelDialogs
   *  
   */
   public void dunklerDialog(){
      fenster.setMessage("Menü Dunkler gedrückt!");
      bild.dunkler();
      this.repaint();      
      bildGeaendert = true;
   }
   /**
   * Methode des hellerDialogs
   *  
   */
   public void hellerDialog(){
      fenster.setMessage("Menü Heller gedrückt!") ;
      //bild = new Farbbild(dataModel.holeBild()) ;         
      bild.heller();
      this.repaint(); 
      bildGeaendert = true;
   }
   
   
   /**
   * Methode des negativDialogs
   *  
   */
   public void negativDialog(){
      fenster.setMessage("Menü Negativ gedrückt!") ;
      //bild = new Farbbild(dataModel.holeBild()) ;         
      bild.negativ();
      this.repaint();
      bildGeaendert = true;
   }
   
   /**   
   * Methode des graustufenDialogs
   *  
   */
   public void grauStufeDialog(){
      fenster.setMessage("Menü GrauStufen gedrückt!") ;
      //bild = new Farbbild(dataModel.holeBild()) ;         
      bild.schwarzweis();
      this.repaint();
      bildGeaendert = true;
   }
   
   /**
   * Methode des schwellenWertDialogs
   *  
   */
   public void schwellenWertDialog(){
      fenster.setMessage("Menü Threshold gedrückt!") ;
      //bild = new Farbbild(dataModel.holeBild()) ;         
      bild.schwellWert();
      this.repaint();
      bildGeaendert = true;
   }
   
   /**
   * Methode des filter6Dialogs
   *  
   */
   public void filter6Dialog(){
      bild.flipVerti();  
      this.repaint();
      bildGeaendert = true;
   }
   
   /**
   * Methode des filter7Dialogs
   *  
   */
   public void filter7Dialog(){
      fenster.setMessage("Menü FILTER7 gedrückt!") ;        
      //bild = new Farbbild(dataModel.holeBild()) ;         
      //bild.filter7(h , w);  
      //this.repaint();
   }   
   
   /**
   * Methode des hilfeDialogs
   *  
   */
   public void hilfeDialog(){fenster.setMessage("Menü Hilfe gedrückt!") ;}
   /**
   * Methode des infoDialogs
   *  
   */
   public void infoDialog(){      
      fenster.setMessage("Menü iNFO gedrückt!") ;
      hilfe = new HilfeDialog();
   }
   
   public void bildaendernDialog(){  
      janein = new JaNeinDialog(fenster);
      
      janein.addConfirmListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            
            if (cmd.equals("yes")) {
               janein.setVisible(false);janein.dispose();
               bildGeaendert = true;
               speichernDialog();
            }
            if (cmd.equals("no")) {
               janein.setVisible(false);janein.dispose();
               bildGeaendert = false;
               ladenDialog();
            }
            if (cmd.equals("cancel")) {
               janein.setVisible(false);janein.dispose();
            }
         }
      });
   }    
   
   public void schliessenaendernDialog(){  
      janein = new JaNeinDialog(fenster);
      
      janein.addConfirmListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            
            if (cmd.equals("yes")) {
               janein.setVisible(false);janein.dispose();
               bildGeaendert = true;
               speichernDialog();
            }
            if (cmd.equals("no")) {
               janein.setVisible(false);janein.dispose();
               bildGeaendert = false;
               fenster.getFrame().setVisible(false);
               fenster.getFrame().dispose();
               System.exit(0);
            }
            if (cmd.equals("cancel")) {
               janein.setVisible(false);janein.dispose();
            }
         }
      });
   }
}
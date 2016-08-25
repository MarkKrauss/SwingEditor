package source.MVC.model;
import source.EditorInterface.FarbbildInterface;

import java.awt.*;
import java.awt.image.*;

import java.awt.geom.*;
import java.util.ArrayList;

/**
 * Hohlt das Farbild und gibt die Bildmanipulation
 * 
 * @author  Markus Krauss
 * @version 0.3
 */
public class Farbbild extends BufferedImage implements FarbbildInterface {
   //public BufferedImage image;
   public int hoehe, breite;
   
   /**
   * Erzeuge ein Farbbild als Kopie von einem BufferedImage.
   * @param image ist das zu kopierende BufferedImage.
   */
   public Farbbild(BufferedImage image)
   {
      super(image.getColorModel(), image.copyData(null), 
      image.isAlphaPremultiplied(), null);
      
      breite = image.getWidth();
      hoehe = image.getHeight();
   }
   
   /**
   * Methode: setzt Pixel
   * @param x X-Koordinate
   * @param y Y-Koordinate
   * @param col Farbwert
   */
   public void setzePixel(int x, int y, Color col) {}   
   /**
   * Methode: gibt Pixel
   * @param x X-Koordinate
   * @param y Y-Koordinate
   */
   public Color gibPixel(int x, int y) {return null ;} 
   
   /**
   * Erzeugt ein dunkleres Bild (Pixel).
   * @param hoehe die aktuelle Hoehe des Bildes
   * @param breite die aktuelle Breite des Bildes
   */
   public void dunkler() {       
      for (int y = 0; y < hoehe; ++y) {
         for (int x = 0; x < breite; ++x) {
            int rgbWert = this.getRGB(x, y);
            Color c = new Color(rgbWert);
            this.setRGB(x, y, c.darker().getRGB()) ;            
         }
      }
   }
   /**
   * Erzeugt ein hellers Bild (Pixel).
   * @param hoehe die aktuelle Hoehe des Bildes
   * @param breite die aktuelle Breite des Bildes
   */
   public void heller() {       
      for (int y = 0; y < hoehe; ++y) {
         for (int x = 0; x < breite; ++x) {
            int rgbWert = this.getRGB(x, y);
            Color c = new Color(rgbWert);
            this.setRGB(x, y, c.brighter().getRGB()) ;            
         }
      }
   }
   /**
   * Erzeugt ein schwarz-weiss Bild (Pixel).
   * @param hoehe die aktuelle Hoehe des Bildes
   * @param breite die aktuelle Breite des Bildes
   */
   public void schwarzweis() {         
      for (int y = 0; y < hoehe; ++y) {
         for (int x = 0; x < breite; ++x) {
            int rgbWert = this.getRGB(x, y);
            Color c = new Color(rgbWert);
            
            /*
            int red   = (int)(c.getRed());
            int green = (int)(c.getGreen());
            int blue  = (int)(c.getBlue());             
            int mw = (red+green+blue)/3;
            */
            
            int red   = (int)(c.getRed() * 0.299);
            int green = (int)(c.getGreen() * 0.587);
            int blue  = (int)(c.getBlue() * 0.114);
            int mw = (red+green+blue);
            
            Color newColor = new Color(mw, mw, mw);
            this.setRGB(x, y, newColor.getRGB()) ;
         }
      }
   }
   /**
   * Erzeugt ein negativ des Bild (Pixel).
   * @param hoehe die aktuelle Hoehe des Bildes
   * @param breite die aktuelle Breite des Bildes
   */
   public void negativ() {         
      for (int y = 0; y < hoehe; ++y) {
         for (int x = 0; x < breite; ++x) {
            int rgbWert = this.getRGB(x, y);
            Color c = new Color(rgbWert);
            
            int red   = 255-c.getRed();
            int green = 255-c.getGreen();
            int blue  = 255-c.getBlue();
            
            Color newColor = new Color(red,green,blue);
            this.setRGB(x, y, newColor.getRGB()) ;
         }
      }
   }
   
   /**
   * Erzeugt die Schwellwerte eines Bildes (Pixel).
   * @param hoehe die aktuelle Hoehe des Bildes
   * @param breite die aktuelle Breite des Bildes
   */
   public void schwellWert() {         
      for (int y = 0; y < hoehe; ++y) {
         for (int x = 0; x < breite; ++x) {
            int rgbWert = this.getRGB(x, y);
            Color c = new Color(rgbWert);
            
            int red   = (int)(c.getRed());
            int green = (int)(c.getGreen());
            int blue  = (int)(c.getBlue());
            
            int mw = (red+green+blue)/3;
            
            
            if (mw<=85) {mw = 0;}
            
            if (mw<=85) {mw = 125;}
            
            if (170<mw) {mw = 255;}
            
            Color newColor = new Color(mw, mw,mw);
            this.setRGB(x, y, newColor.getRGB()) ;
         }
      }
   }
   
   /**
   * Spiegelt ein Bild (Pixel).
   * @param hoehe die aktuelle Hoehe des Bildes
   * @param breite die aktuelle Breite des Bildes
   */
   public void flipVerti() {       
      for (int y = 0; y < hoehe; ++y) {
         for (int x = 0; x < breite/2; ++x) {
            
            int rgbWert1 = this.getRGB(x, y);           
            int rgbWert2 = this.getRGB(breite-x-1, y);
            
            
            this.setRGB(breite-x-1, y, rgbWert1);
            this.setRGB(x, y, rgbWert2);            
         }
      }                                
   }
   
   /**
   * Noch kein Filter Aktiv!
   * @param hoehe die aktuelle Hoehe des Bildes
   * @param breite die aktuelle Breite des Bildes
   */
   public void filter7() { 
      final double GS_RED = 0.3;
      final double GS_GREEN = 0.59;
      final double GS_BLUE = 0.1;
      final double depth = 20;
      
      for (int y = 0; y < hoehe; ++y) {
         for (int x = 0; x < breite; ++x) {
            int rgbWert = this.getRGB(x, y);
            Color c = new Color(rgbWert);
            
            int R   = (int)(c.getRed());
            int G = (int)(c.getGreen());
            int B  = (int)(c.getBlue());
            
            
            // apply grayscale sample
            B = G = R = (int)(GS_RED * R + GS_GREEN * G + GS_BLUE * B);
            
            // apply intensity level for sepid-toning on each channel
            R += (depth * R);
            if(R > 255) { R = 255; }
            
            G += (depth * G);
            if(G > 255) { G = 255; }
            
            B += (depth * B);
            if(B > 255) { B = 255; }
            
            Color newColor = new Color(R, G,B);
            this.setRGB(x, y, newColor.getRGB()) ;
         }
      }
   }
}
package source.EditorInterface;

import java.awt.* ;

/**
 * Schnittstelle des FarbbildInterface
 *
 * @author Markus Krauss
 * @version 0.1
 */
public interface FarbbildInterface {
   public void setzePixel(int x, int y, Color col) ;
   public Color gibPixel(int x, int y) ;
}
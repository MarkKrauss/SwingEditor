package source.EditorInterface;

import source.MVC.view.EditorException;

import java.awt.image.* ;
/**
 * Schnittstelle des DatenModelInterface
 *
 * @author Markus Krauss
 * @version 0.1
 */
public interface DatenModelInterface {
   public void laden() throws EditorException;
   public void speichern(BufferedImage bild) throws EditorException;
   public BufferedImage holeBild() ;
   public String gibFileName() ;
}

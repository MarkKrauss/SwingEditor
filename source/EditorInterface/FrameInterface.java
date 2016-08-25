package source.EditorInterface;

import source.MVC.view.SwingEditor;
import source.MVC.view.NachrichtenZeile;

import java.awt.*;
import javax.swing.*;

/**
 * Schnittstelle des FrameInterface
 *
 * @author Markus Krauss
 * @version 0.1
 */
public interface FrameInterface {
   public JFrame getFrame();
   public MenueLeisteInterface getMenueLeiste();
   public BildAreaInterface getBildArea();
   public void setMessage(String nachricht);
   //public void isBildGeandert();
}
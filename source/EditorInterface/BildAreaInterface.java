package source.EditorInterface;
/**
 * Schnittstelle des BildAreaInterface
 *
 * @author Markus Krauss
 * @version 0.1
 */
public interface BildAreaInterface {
   public void ladenDialog();
   public void speichernDialog();
   public void beendenDialog();
   
   public void originalDialog();
   public void dunklerDialog();
   public void hellerDialog();
   public void negativDialog();
   public void grauStufeDialog();
   public void schwellenWertDialog();
   public void filter6Dialog();
   public void filter7Dialog();
   
   public void hilfeDialog() ;
   public void infoDialog() ;
   
   //public void isBildGeandert();
}

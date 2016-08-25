package source.EditorInterface;
/**
 * Schnittstelle der Menueleiste zum Deaktivieren /
 * Aktivieren von MenüEinträgen.
 *
 * @author Markus Krauss
 * @version 0.2
 */
public interface MenueLeisteInterface {
   // globale Konstanten für Menü-Aktionen
   public final static String LOAD = "laden";
   public final static String SAVE_AS = "speichernUnter";
   public final static String EXIT = "ende";
   public final static String ORIGINAL = "original";
   public final static String DARK = "filter1";
   public final static String BRIGHT = "filter2";
   public final static String NEGATIV = "filter3";
   public final static String GREY = "filter4";
   public final static String THRESHOLD = "filter5";
   public final static String FILTER6 = "filter6";
   public final static String FILTER7 = "filter7";
   public final static String HELP = "hilfe";
   public final static String INFO = "info";
   
   //Dialoge
   //public final static String YES = "yes";
   
   public void menueSpeichernUnter(boolean b); 
   public void menueBearbeitenBool(boolean b); 
   
}
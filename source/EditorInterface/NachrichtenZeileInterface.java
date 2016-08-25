package source.EditorInterface;

/**
 * Schnittstelle der Nachrichtenzeile mit Konstanten
 *
 * @author Markus Krauss
 * @version 0.2
 */
public interface NachrichtenZeileInterface {
   public static final String FONT_MESSAGE = "Courier";
   public static final int FONT_MESSAGE_SIZE = 14;

   /**
   * Methode: setMessage
   *
   * @param t Setze die Nachricht
   */
   public void setMessage(String t);

   public String getMessage();
}

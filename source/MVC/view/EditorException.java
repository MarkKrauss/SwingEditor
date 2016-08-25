package source.MVC.view;

/**
 * Mit Hilfe der EditorException-Klasse werden die Java-Fehlermeldungen
 * durch eigene Fehlertokens ersetzt, die später sprachabhängig
 * ausgegeben werden.
 *
 
 * @author Prof. Dr. M. Scheer, THM
 * @version 19.11.2011
*/
public class EditorException extends Exception {
    /**
    * Konstruktor EditorfileCHooser
    *
    * @param fehlerMeldung gibt die Fehlermeldung aus
    */
   public EditorException(String fehlerMeldung) {
      // Konstruktor der Klasse Exception wird aufgerufen,
      // ihm wird die Fehlermeldung übergeben
      super(fehlerMeldung);
   }
}

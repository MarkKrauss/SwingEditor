package source.EditorInterface ;

/**
 * Schnittstelle des LangModelInterface
 *
 * @author Markus Krauss
 * @version 0.1
 */
public interface LangModelInterface {  
   // Für den Editor Basisname anpassen,
   // Basisname mit Verzeichnis angeben!
   // Basisname der Sprachdatei für den Test:
   public final static String LANGUAGE_FILE = "lang_de_DE" ;
   
   // Keys für die Menüs
   public final static String FILE = "menu.file" ;
   public final static String FILE_LOAD = "menu.file.load" ;
   public final static String FILE_SAVE_AS = "menu.file.save.as" ;
   public final static String FILE_EXIT = "menu.file.exit" ;
   
   public final static String EDIT = "menu.edit" ;
   public final static String EDIT_ORIGINAL = "menu.edit.original" ;
   public final static String EDIT_DARK = "menu.edit.dark" ;
   public final static String EDIT_BRIGHT = "menu.edit.bright" ;
   public final static String EDIT_NEGATIV = "menu.edit.negativ" ;
   public final static String EDIT_GREY = "menu.edit.grey" ;
   public final static String EDIT_THRESHOLD = "menu.edit.threshold" ;
   public final static String EDIT_REFLECT = "menu.edit.reflect" ;
   public final static String EDIT_FILTER7 = "menu.edit.filter7" ;
   
   public final static String HELP = "menu.help" ;
   public final static String HELP_INFO = "menu.help.info" ;
   
   // Keys für die Buttons
   public final static String NO_BUTTONTEXT = "no.button" ;
   public final static String YES_BUTTONTEXT = "yes.button" ;
   public final static String OK_BUTTONTEXT = "ok.button" ;
   public final static String CANCEL_BUTTONTEXT = "cancel.button" ;
   
   // Texte
   public final static String TEXT_LINE = "text.line" ; // Label Meldungszeile
   public final static String TEXT_FILTER_DESCRIPTION = "text.filter.description" ; // JChooser-Filter
   public final static String PIC_UNKNOWN = "pic.unkwown" ; // Standard-Dateiname
   
   public final static String MESSAGE1 = "message1" ; // Datei überschreiben?
   public final static String MESSAGE2 = "message2" ; // Standard-Ini-Datei geladen
   public final static String MESSAGE3 = "message3" ; // Programm beenden
   public final static String MESSAGE4 = "message4" ; // Änderungen speichern
   public final static String MESSAGE5 = "message5" ; // Dateidialog abgebrochen!
   public final static String MESSAGE6 = "message6" ; // Zur Zeit keine Funkion!
   public final static String MESSAGE7 = "message7" ; // Datei zuerst speichern!
   public final static String MESSAGE8 = "message8" ; // Datei gespeichert!
   public final static String MESSAGE9 = "message9" ; // Frage
   
   public final static String CONFIRM_DIALOG_TITLE = "confirm.dialog.title" ;
   public final static String CONFIRM_DIALOG_TEXT = "confirm.dialog.text" ;
   
   // Fehlermeldungen
   public final static String ERROR1 = "error1" ; // Datei nicht gefunden.
   public final static String ERROR2 = "error2" ; // Fehler beim Lesen der Datei.
   public final static String ERROR3 = "error3" ; // Fehler beim Schreiben der Datei.
   public final static String ERROR4 = "error4" ; // Fehler beim Schreiben der Ini-Datei
   public final static String ERROR5 = "error5" ; // Sprachdatei nicht gefunden 
   public final static String ERROR6 = "error6" ;
   public final static String ERROR7 = "error7" ;
   public final static String ERROR8 = "error8" ;
   
   // Weitere Keys für die Sprachdatei
   public final static String BEENDEN = "beenden" ;
   public final static String SICHER = "sicher" ;
   
   abstract public String getLangValue(String key) ;
   
   abstract public int getLangValueToInt(String key) ;
}
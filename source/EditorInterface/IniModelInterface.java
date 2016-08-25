package source.EditorInterface ;

/**
 * Schnittstelle des IniModelInterface
 *
 * @author Markus Krauss
 * @version 0.1
 */
public interface IniModelInterface {
   // Konstanten für den Namen der INI-Datei
   public final static String INIFILE = "editor.ini";
   public final static String INIFILE_HEADER = "Standard Editor INI-File";
   
   // Keys für die Ini-Property
   public final static String TITLE = "frame.title";
   public final static String X_SIZE = "frame.x.size";
   public final static String Y_SIZE = "frame.y.size";
   public final static String X_POS = "frame.x.position";
   public final static String Y_POS = "frame.y.position";
   public final static String PIC_WIDTH = "bildarea.width";
   public final static String PIC_HEIGHT = "bildarea.height";
   public final static String LANG = "current.language";
   public final static String COUNTRY = "current.country";
   public final static String FILTER = "file.filter";
   public final static String BACKUP = "file.backup";
   
   abstract public  String getIniValue(String key) ;
   abstract public  int getIniValueToInt(String key) ; 
}

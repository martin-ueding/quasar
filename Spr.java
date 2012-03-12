import java.util.ResourceBundle;

public class Spr
{
  static ResourceBundle B = ResourceBundle.getBundle("sprache");

  public static String get(String ident) {
    return B.getString(ident);
  }
}

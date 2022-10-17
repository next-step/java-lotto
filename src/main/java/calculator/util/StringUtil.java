package calculator.util;

public class StringUtil {

  private StringUtil() {
    throw new IllegalArgumentException("utility class");
  }

  public static boolean isNullOrEmpty(String str) {
    return str == null || str.length() == 0;
  }

  public static boolean isNumeric(String str) {
    boolean numeric = true;
    try {
      Integer.parseInt(str);
    } catch (NumberFormatException e) {
      numeric = false;
    }
    return numeric;
  }
}

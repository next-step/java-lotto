package calculator.util;

public class StringUtil {

  public static String[] split(String text) {
    return text.split(" ");
  }
  public static int parseInteger(String str) {
    return Integer.parseInt(str);
  }
}

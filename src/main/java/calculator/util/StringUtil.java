package calculator.util;

import calculator.exception.BlankCheckException;

public class StringUtil {

  public static String[] split(String text) {
    return text.split(" ");
  }

  public static int parseInteger(String str) {
    return Integer.parseInt(str);
  }

  public static void isBlank(String text) {
    if(text == null || text.isBlank()) {
      throw new BlankCheckException();
    }
  }
}

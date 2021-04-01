package calculator.util;

public final class StringUtil {

  private StringUtil() {
  }

  public static boolean isBlank(String str) {
    return str == null || str.isEmpty() || str.trim().isEmpty();
  }

}
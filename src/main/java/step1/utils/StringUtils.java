package step1.utils;

public class StringUtils {

  public static final int ZERO = 0;

  private StringUtils() {}

  public static boolean isEmpty(String input) {
    return input == null || input.trim().isEmpty();
  }
}

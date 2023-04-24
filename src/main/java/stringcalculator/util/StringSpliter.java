package stringcalculator.util;

public class StringSpliter {

  public static final String DEFAULT_DELIMITER = " ";

  public static String[] split(String input) {
    return input.split(DEFAULT_DELIMITER);
  }
}

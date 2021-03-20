package stringCalculator.domain;

public class StringSpliter {
  private static final String DELIMETER = ",|:";

  public static String[] split(String input) {
    return input.split(DELIMETER);
  }
}

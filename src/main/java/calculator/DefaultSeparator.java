package calculator;

public class DefaultSeparator {

  private static final String STRING_CALCULATOR_DELIIMITER = ",|:";

  public static String[] separate(String input) {
    return input.split(STRING_CALCULATOR_DELIIMITER);
  }
}

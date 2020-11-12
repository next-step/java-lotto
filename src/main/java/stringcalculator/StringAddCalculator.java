package stringcalculator;

public class StringAddCalculator {

  private static final int DEFAULT_RETURN_VALUE = 0;

  public static int splitAndSum(String input) {

    if (isInvalidInput(input)) {
      return DEFAULT_RETURN_VALUE;
    }

    return Integer.parseInt(input);
  }

  private static boolean isInvalidInput(String input) {
    return input == null || input.isEmpty();
  }
}

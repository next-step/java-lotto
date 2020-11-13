package stringcalculator;

public class StringAddCalculator {

  private static final int DEFAULT_RETURN_VALUE = 0;
  private static final String DELIMITER = ",";

  public static int splitAndSum(String input) {

    int result = 0;

    if (isInvalidInput(input)) {
      return DEFAULT_RETURN_VALUE;
    }

    String[] tokenizedInputs = input.split(DELIMITER);

    for (String tokenizedInput : tokenizedInputs) {
      result += castToInteger(tokenizedInput);
    }

    return result;
  }

  private static boolean isInvalidInput(String input) {
    return input == null || input.isEmpty();
  }

  private static int castToInteger(String tokenizedInput) {
    return Integer.parseInt(tokenizedInput);
  }
}

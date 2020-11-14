package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final int DEFAULT_RETURN_VALUE = 0;

  private StringAddCalculator() {
  }

  public static int splitAndSum(String rawInput) {

    int result = 0;

    if (isInvalidInput(rawInput)) {
      return DEFAULT_RETURN_VALUE;
    }

    Splitter splitter = new Splitter();
    String[] splitInputs = splitter.splitInput(rawInput);

    for (String splitInput : splitInputs) {
      result += castToInteger(splitInput);
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

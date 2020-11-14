package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final int DEFAULT_RETURN_VALUE = 0;
  private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

  private StringAddCalculator() {
  }

  public static int splitAndSum(String rawInput) {

    int result = 0;

    if (isInvalidInput(rawInput)) {
      return DEFAULT_RETURN_VALUE;
    }

    String[] splitInputs = splitInput(rawInput);

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

  private static String[] splitInput(String input) {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }

    return input.split(DEFAULT_DELIMITER_REGEX);
  }
}
